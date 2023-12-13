package com.alex.play.shop.constans;

/**
 * 缓存常量
 *
 * @author 东方亦
 * 2019/4/25 10:20
 */
public interface RedisConstants {

    /**
     * 缓存分隔符
     */
    String SPLIT = ":";

    /**
     * 缓存公共前缀
     */
    String PREFIX = "play_shop" + SPLIT;

    /**
     * Redis session 缓存前缀
     */
    String REDIS_SESSION_PREFIX = PREFIX + "session";

    /**
     * Redis web端token 缓存前缀
     */
    String REDIS_WEB_ADMIN_TOKEN_PREFIX = PREFIX + "web_admin_token" + SPLIT;

    /**
     * Redis web端token 缓存前缀
     */
    String REDIS_WEB_ADMIN_REFRESH_TOKEN_PREFIX = PREFIX + "web_admin_refresh_token" + SPLIT;

    /**
     * redis webToken分布式锁key
     */
    String REDIS_WEB_ADMIN_LOCK_PREFIX =  PREFIX + "web_admin_lock" + SPLIT;

    /**
     * redis sma_appToken分布式锁key
     */
    String REDIS_SMA_APP_LOCK_PREFIX =  PREFIX + "sma_app_lock" + SPLIT;

    /**
     * redis sma_appToken分布式锁key
     */
    String REDIS_SMA_APP_V2_LOCK_PREFIX =  PREFIX + "sma_app_v2_lock" + SPLIT;

    /**
     * redis interactive_screenToken分布式锁key
     */
    String REDIS_INTERACTIVE_SCREEN_LOCK_PREFIX =  PREFIX + "interactive_screen_lock" + SPLIT;

    /**
     * redis data_screenToken分布式锁key
     */
    String REDIS_DATA_SCREEN_LOCK_PREFIX =  PREFIX + "data_screen_lock" + SPLIT;

    /**
     * redis mini_appToken分布式锁key
     */
    String REDIS_MINI_APP_LOCK_PREFIX =  PREFIX + "mini_app_lock" + SPLIT;

    /**
     * redis mini_appToken分布式锁key
     */
    String REDIS_EQUIP_APP_LOCK_PREFIX =  PREFIX + "equip_app_lock" + SPLIT;

    /**
     * Redis 移动端token 缓存前缀
     */
    String REDIS_SMA_APP_TOKEN_PREFIX = PREFIX + "sma_app_token" + SPLIT;

    /**
     * Redis 移动端token 缓存前缀
     */
    String REDIS_SMA_APP_REFRESH_TOKEN_PREFIX = PREFIX + "sma_app_refresh_token" + SPLIT;

    /**
     * Redis 移动端token 缓存前缀
     */
    String REDIS_SMA_APP_V2_TOKEN_PREFIX = PREFIX + "sma_app_v2_token" + SPLIT;

    /**
     * Redis 移动端token 缓存前缀
     */
    String REDIS_SMA_APP_V2_REFRESH_TOKEN_PREFIX = PREFIX + "sma_app_v2_refresh_token" + SPLIT;

    /**
     * Redis 互动屏token 缓存前缀
     */
    String REDIS_INTERACTIVE_SCREEN_TOKEN_PREFIX = PREFIX + "interactive_screen_token" + SPLIT;

    /**
     * Redis 互动屏token 缓存前缀
     */
    String REDIS_INTERACTIVE_SCREEN_REFRESH_TOKEN_PREFIX = PREFIX + "interactive_screen_refresh_token" + SPLIT;

    /**
     * Redis 数据大屏token 缓存前缀
     */
    String REDIS_DATA_SCREEN_TOKEN_PREFIX = PREFIX + "data_screen_token" + SPLIT;

    /**
     * Redis 数据大屏token 缓存前缀
     */
    String REDIS_DATA_SCREEN_REFRESH_TOKEN_PREFIX = PREFIX + "data_screen_refresh_token" + SPLIT;

    /**
     * Redis 小程序token 缓存前缀
     */
    String REDIS_MINI_APP_TOKEN_PREFIX = PREFIX + "min_app_token" + SPLIT;

    /**
     * Redis 小程序token 缓存前缀
     */
    String REDIS_MINI_APP_REFRESH_TOKEN_PREFIX = PREFIX + "min_app_refresh_token" + SPLIT;

    /**
     * Redis 设备登录用户 缓存前缀
     */
    String REDIS_EQUIPMENT_LOGIN_USER_PREFIX = PREFIX + "equipment_login_user" + SPLIT;

    /**
     * Redis 设备token 缓存前缀
     */
    String REDIS_EQUIPMENT_USER_TOKEN_PREFIX = PREFIX + "equipment_user_token" + SPLIT;

    /**
     * Redis 设备token 缓存前缀
     */
    String REDIS_EQUIPMENT_REFRESH_USER_TOKEN_PREFIX = PREFIX + "equipment_refresh_user_token" + SPLIT;

    /**
     * Redis 用户信息缓存前缀
     */
    String REDIS_USER_INFO_PREFIX = PREFIX + "user_info" + SPLIT;

    /**
     * Redis 用户权限缓存前缀
     */
    String REDIS_USER_COMPETENCE_PREFIX = PREFIX + "user_competence" + SPLIT;

    /**
     * Redis 客户端 缓存前缀
     */
    String REDIS_CLIENTS_PREFIX = PREFIX + "clients" + SPLIT;

    /**
     * 验证码缓存key
     */
    String DEFAULT_CODE_KEY = PREFIX + "code" + SPLIT;

    /**
     * 默认过期时间 60秒
     */
    String THIRD_BUFF = "1024BT";

    /**
     * 默认过期时间 60秒
     */
    int DEFAULT_EXPIRE_SECONDS = 60;

    /**
     * 默认过期时间 300秒
     */
    int SCAN_LOGIN_EXPIRE_SECONDS = 300;

}
