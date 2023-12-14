package com.alex.play.shop.jwt;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import com.alex.play.shop.constans.TokenContants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JwtTokenProvider
 * @Description TODO
 * @Author Alex
 * @Date 2023/12/4 20:03
 * @Version 1.0
 */
@Data
@Component
public class JwtTokenProvider {

    private static String secretKey = "jwtSecretKey";
    public String createToken(Long uid, String userAccount, Integer type) {
        Long expireTime = System.currentTimeMillis() + TokenContants.ACCESS_TOKEN_EXPIRE;
        if (type == 1) {
            expireTime = System.currentTimeMillis() + TokenContants.REFRESH_TOKEN_EXPIRE;
        }
        Long finalExpireTime = expireTime;
        Map<String, Object> map = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;

            {
                put("user_id", uid);
                put("user_account", userAccount);
                put("expire_time", finalExpireTime);
            }
        };
        return JWTUtil.createToken(map, secretKey.getBytes());
    }

    public JWTPayload parseToken(String token) {
        try {
            if (JWTUtil.verify(token, secretKey.getBytes())) {
                JWT jwt = JWTUtil.parseToken(token);
                return jwt.getPayload();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

}
