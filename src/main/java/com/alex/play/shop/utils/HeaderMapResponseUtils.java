package com.alex.play.shop.utils;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName HeaderMapResponseUtils
 * @Description TODO
 * @Author Alex
 * @Date 2023/12/13 22:13
 * @Version 1.0
 */
public class HeaderMapResponseUtils extends HttpServletResponseWrapper {
    public HeaderMapResponseUtils(HttpServletResponse response) {
        super(response);
    }
    public void responseMethod(BaseResponse<String> baseResponse) throws IOException {
        ServletResponse response = getResponse();
        response.getOutputStream().write(JSON.toJSONString(baseResponse).getBytes(StandardCharsets.UTF_8));
        response.getOutputStream().flush();
    }

}
