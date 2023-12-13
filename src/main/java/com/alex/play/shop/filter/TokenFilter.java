package com.alex.play.shop.filter;

import com.alex.play.shop.constans.CodeConstants;
import com.alex.play.shop.constans.MessageConstants;
import com.alex.play.shop.jwt.JwtTokenProvider;
import com.alex.play.shop.utils.BaseResponse;
import com.alex.play.shop.utils.HeaderMapRequestUtils;
import com.alex.play.shop.utils.HeaderMapResponseUtils;
import com.alex.play.shop.utils.RedisUtils;
import com.alibaba.fastjson2.JSON;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName TokenFilter
 * @Description TODO
 * @Author Alex
 * @Date 2023/12/13 22:01
 * @Version 1.0
 */
@Order(1)
@WebFilter(urlPatterns = "/*", filterName = "TokenFilter")
@Configuration
@Slf4j
public class TokenFilter implements Filter {

    @Resource
    JwtTokenProvider jwtTokenProvider;

    @Resource
    RedisUtils redisUtils;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("====过滤器获取到接口请求====");
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        HeaderMapRequestUtils requestWrapper = new HeaderMapRequestUtils((HttpServletRequest) servletRequest);
        HeaderMapResponseUtils responseWrapper = new HeaderMapResponseUtils((HttpServletResponse) servletResponse);

        /**
         * 获取请求urI
         */
        String requestURI = httpRequest.getRequestURI();

        /**
         * rpc：系统内部远程调用url
         * noAuth：无需认证的接口，即不需要携带token
         * public：需要携带token，但不需要权限
         * admin：仅供admin账户调用的url
         */
        if (requestURI.contains("/noAuth") || requestURI.contains("/rpc")) {
            filterChain.doFilter(servletRequest,servletResponse);
            System.out.println("放过带有noAuth的请求");
            return;
        }

        /**
         * 验证token是否为空
         */
        String token = httpRequest.getHeader("Authorization");
        if (!StringUtils.hasText(token) || !jwtTokenProvider.checkToken(token)) {
            System.out.println("验证token失败");
            BaseResponse<String> baseResponse = BaseResponse.failure(Integer.toString(CodeConstants.CODE_CLIENT_ERROR_PERMISSION_NO), MessageConstants.MESSAGE_CLIENT_ERROR_INTERCEPT);
            responseWrapper.responseMethod(baseResponse);
            return;
        }

        /**
         * 验证token是否过期
         */
        Claims claims = jwtTokenProvider.parseToken(token);
        if (claims.getExpiration().getTime() < System.currentTimeMillis()) {
            System.out.println("token过期");
            BaseResponse<String> baseResponse = BaseResponse.failure(Integer.toString(CodeConstants.CODE_CLIENT_ERROR_REJECT_TIMEOUT), MessageConstants.MESSAGE_CLIENT_ERROR_REJECT_TIMEOUT);
            responseWrapper.responseMethod(baseResponse);
            return;
        }

        /**
         * 封装信息至请求头
         */
        String userId = claims.get("user_id").toString();
        String userAccount = claims.get("user_account").toString();

        requestWrapper.addHeader("USER_ID", userId);
        requestWrapper.addHeader("USER_ACCOUNT", userAccount);

        filterChain.doFilter(requestWrapper, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
