package com.alex.play.shop.constans;

/**
 * @Description: 状态码code常量类
 * @Author: 东方亦
 * @Date: 2020/9/14 5:17 下午
 **/
public interface CodeConstants {

    /**
     * @Description: 一切 ok
     **/
    int CODE_OK = 200;

    /**
     * @Description: 用户端错误
     **/
    int CODE_CLIENT_ERROR = 10001;
    /**
     * @Description: 用户注册错误
     **/
    int CODE_CLIENT_ERROR_REGISTER = 10100;
    /**
     * @Description: 用户未同意隐私协议
     **/
    int CODE_CLIENT_ERROR_NO_PRIVACY_AGREEMENT = 10101;
    /**
     * @Description: 用户名校验失败
     **/
    int CODE_CLIENT_ERROR_USERNAME_CHECK = 10110;
    /**
     * @Description: 用户名已存在
     **/
    int CODE_CLIENT_ERROR_USERNAME_EXISTS = 10111;
    /**
     * @Description: 用户名包含敏感词
     **/
    int CODE_CLIENT_ERROR_USERNAME_INCLUDE_SENSITIVE = 10112;
    /**
     * @Description: 用户名包含特殊字符
     **/
    int CODE_CLIENT_ERROR_USERNAME_INCLUDE_SPECIAL_CHARACTER = 10113;
    /**
     * @Description: 校验码输入错误
     **/
    int CODE_CLIENT_ERROR_CODE_CHECK_FAILED = 10130;
    /**
     * @Description: 短信校验码输入错误
     **/
    int CODE_CLIENT_ERROR_SMS_CHECK_FAILED = 10131;
    /**
     * @Description: 用户证件异常
     **/
    int CODE_CLIENT_ERROR_ID_CARD = 10140;
    /**
     * @Description: 用户证件类型未选择
     **/
    int CODE_CLIENT_ERROR_ID_CARD_NO_CHOOSE = 10141;
    /**
     * @Description: 大陆身份证编号校验非法
     **/
    int CODE_CLIENT_ERROR_ID_CARD_ILLEGAL_VERIFY = 10142;
    /**
     * @Description: 用户基本信息校验失败
     **/
    int CODE_CLIENT_ERROR_INFO_CHECK_FAILED = 10150;
    /**
     * @Description: 手机格式校验失败
     **/
    int CODE_CLIENT_ERROR_INFO_PHONE_CHECK_FAILED = 10151;
    /**
     * @Description: 手机号码与当前绑定不符
     **/
    int CODE_CLIENT_ERROR_INFO_PHONE_CHECK_BIND_NO = 10152;

    /**
     * @Description: 用户登陆异常
     **/
    int CODE_CLIENT_ERROR_LOGIN = 10200;
    /**
     * @Description: 用户账户不存在
     **/
    int CODE_CLIENT_ERROR_LOGIN_NO_EXISTS = 10201;
    /**
     * @Description: 用户账户被冻结
     **/
    int CODE_CLIENT_ERROR_LOGIN_NO_ACTIVE = 10202;
    /**
     * @Description: 用户账户已作废
     **/
    int CODE_CLIENT_ERROR_LOGIN_DELETE = 10203;
    /**
     * @Description: 用户身份校验失败
     **/
    int CODE_CLIENT_ERROR_IDENTITY = 10220;
    /**
     * @Description: 访问权限异常
     **/
    int CODE_CLIENT_ERROR_PERMISSION = 10300;
    /**
     * @Description: 访问未授权
     **/
    int CODE_CLIENT_ERROR_PERMISSION_NO = 10301;
    /**
     * @Description: 未携带请求头
     **/
    int CODE_CLIENT_ERROR_REQUEST_HEADER_NOT_FOUND = 10302;
    /**
     * @Description: 授权已过期
     **/
    int CODE_CLIENT_ERROR_REJECT_TIMEOUT = 10311;
    /**
     * @Description: 用户访问被拦截
     **/
    int CODE_CLIENT_ERROR_INTERCEPT = 10320;
    /**
     * @Description: 用户请求参数校验异常
     **/
    int CODE_CLIENT_ERROR_PARAMS = 10400;
    /**
     * @Description: 请求必填参数为空
     **/
    int CODE_CLIENT_ERROR_PARAMS_EMPTY_MUST = 10410;

    /**
     * @Description: 系统执行出错
     **/
    int CODE_SERVICE_ERROR_EXEC = 20001;


}
