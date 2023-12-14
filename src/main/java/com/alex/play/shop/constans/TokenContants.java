package com.alex.play.shop.constans;

/**
 * @ClassName TokenContants
 * @Description TODO
 * @Author Alex
 * @Date 2023/12/14 13:05
 * @Version 1.0
 */
public interface TokenContants {

    // accessToken过期时间
    public static final long ACCESS_TOKEN_EXPIRE = 1000;
    // refreshToken过期时间
    public static final long REFRESH_TOKEN_EXPIRE = 1000 * 60 * 60 * 2;
}
