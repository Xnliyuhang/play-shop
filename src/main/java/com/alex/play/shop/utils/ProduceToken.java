package com.alex.play.shop.utils;

import cn.hutool.core.text.StrBuilder;
import com.alex.play.shop.constans.RedisConstants;
import com.alex.play.shop.constans.TokenContants;
import com.alex.play.shop.entity.vo.TokenVO;
import com.alex.play.shop.jwt.JwtTokenProvider;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;


/**
 * @ClassName ProduceToken
 * @Description TODO
 * @Author Alex
 * @Date 2023/12/14 16:32
 * @Version 1.0
 */
@Component
public class ProduceToken {
    @Resource
    JwtTokenProvider jwtTokenProvider;

    @Resource
    RedisUtils redisUtils;

    public TokenVO getToken(Long userId, String userAccount,String callType){
        TokenVO tokenVO = createToken(userId, userAccount);
        String accessTokenKey = String.valueOf(StrBuilder.create().append(RedisConstants.REDIS_WEB_ADMIN_TOKEN_PREFIX).append(userId));
        String refreshTokenKey = String.valueOf(StrBuilder.create().append(RedisConstants.REDIS_WEB_ADMIN_REFRESH_TOKEN_PREFIX).append(userId));
        if (callType.equals("login")) {
            redisUtils.setNX(RedisConstants.REDIS_WEB_ADMIN_LOCK_PREFIX + userId, "1", TokenContants.ACCESS_TOKEN_EXPIRE);
            redisUtils.del(accessTokenKey);
            redisUtils.del(refreshTokenKey);
            redisUtils.set(accessTokenKey,tokenVO.getToken(), TokenContants.ACCESS_TOKEN_EXPIRE);
            redisUtils.cacheValue(refreshTokenKey,tokenVO.getRefreshToken(),TokenContants.REFRESH_TOKEN_EXPIRE);
            System.out.println("accessTokenKey: " + accessTokenKey + "  --> accessToken: " + tokenVO.getToken());
            System.out.println("refreshTokenKey: " + refreshTokenKey + "  --> refreshToken: " + tokenVO.getRefreshToken());
            return tokenVO;
        }
        Boolean lock = redisUtils.setNX(RedisConstants.REDIS_WEB_ADMIN_LOCK_PREFIX + userId, "1", TokenContants.ACCESS_TOKEN_EXPIRE);
        if (callType.equals("refresh")) {
            //未获取到锁，token存在，不需要刷新
            if (!lock) {
                System.out.println("token存在，不需要刷新");
                tokenVO.setToken((String) redisUtils.get(accessTokenKey));
                tokenVO.setRefreshToken((String) redisUtils.get(refreshTokenKey));
                redisUtils.upExpirationTime(refreshTokenKey,TokenContants.REFRESH_TOKEN_EXPIRE);
                return tokenVO;
            }
            //获取到锁，token不存在，刷新token后返回
            System.out.println("token不存在，刷新token后返回");
            redisUtils.del(RedisConstants.REDIS_WEB_ADMIN_TOKEN_PREFIX + userId);
            redisUtils.set(accessTokenKey,tokenVO.getToken(), TokenContants.ACCESS_TOKEN_EXPIRE);
            tokenVO.setRefreshToken((String) redisUtils.get(refreshTokenKey));
            return tokenVO;
        }
        return null;
    }

    private TokenVO createToken(Long userId, String userAccount) {
        TokenVO tokenVO = new TokenVO();
        String token;
        String refreshToken;
        token = jwtTokenProvider.createToken(userId, userAccount, 0);
        refreshToken = jwtTokenProvider.createToken(userId, userAccount, 1);
        tokenVO.setToken(token);
        tokenVO.setRefreshToken(refreshToken);
        return tokenVO;
    }
}