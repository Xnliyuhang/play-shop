package com.alex.play.shop.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

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
    //常量
    public static final long EXPIRE = 1000 * 60 * 60 * 7; //token过期时间

    //    @param id 当前用户ID
    //    @param issuer 该JWT的签发者，是否使用是可选的
    //    @param subject 该JWT所面向的用户，是否使用是可选的
    //    @param ttlMillis 什么时候过期，这里是一个Unix时间戳，是否使用是可选的
    //    @param audience 接收该JWT的一方，是否使用是可选的
    //生成token字符串的方法
    public String createToken(String uid,String userAccount) {

        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")    //头部信息
                .setHeaderParam("alg", "HS256")    //头部信息
                //下面这部分是payload部分
                // 设置默认标签
                .setSubject("dailyblue")    //设置jwt所面向的用户
                .setIssuedAt(new Date())    //设置签证生效的时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))    //设置签证失效的时间
                //自定义的信息，这里存储id和姓名信息
                .claim("user_id", uid)  //设置token主体部分 ，存储用户信息
                .claim("user_account", userAccount)
                //下面是第三部分
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
        // 生成的字符串就是jwt信息，这个通常要返回出去
        return JwtToken;
    }

    /**
     * 判断token是否存在与有效
     * 直接判断字符串形式的jwt字符串
     *
     * @param Token
     * @return
     */
    public boolean checkToken(String Token) {
        if (StringUtils.isEmpty(Token)) return false;
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(Token);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效，是否被篡改
     * 因为通常jwt都是在请求头中携带，此方法传入的参数是请求
     *
     * @param request
     * @return
     */
    public boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");//注意名字必须为token才能获取到jwt
            if (StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token字符串获取用户id
     * 这个方法也直接从http的请求中获取id的
     *
     * @param token
     * @return
     */
    public String getUidByToken(String token) {
//        String jwtToken = request.getHeader("token");
        if (StringUtils.isEmpty(token)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return claims.get("uid").toString();
    }

    /**
     * 解析JWT
     * @param token
     * @return
     */
    public Claims parseToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return claims;
    }
}
