package com.alex.play.shop.constans;

/**
 * @Description: 状态码message常量类
 * @Author: 东方亦
 * @Date: 2020/9/14 5:17 下午
 **/
public interface MessageConstants {

    /**
     * @Description: 一切 ok
     **/
    String MESSAGE_OK = "正常";

    /**
     * @Description: 用户端错误
     **/
    String MESSAGE_CLIENT_ERROR = "用户端错误";
    /**
     * @Description: 用户注册错误
     **/
    String MESSAGE_CLIENT_ERROR_REGISTER = "用户注册错误";
    /**
     * @Description: 用户未同意隐私协议
     **/
    String MESSAGE_CLIENT_ERROR_NO_PRIVACY_AGREEMENT = "用户未同意隐私协议";
    /**
     * @Description: 用户名校验失败
     **/
    String MESSAGE_CLIENT_ERROR_USERNAME_CHECK = "用户名校验失败";
    /**
     * @Description: 用户名已存在
     **/
    String MESSAGE_CLIENT_ERROR_USERNAME_EXISTS = "用户名已存在";
    /**
     * @Description: 用户名包含敏感词
     **/
    String MESSAGE_CLIENT_ERROR_USERNAME_INCLUDE_SENSITIVE = "用户名包含敏感词";
    /**
     * @Description: 用户名包含特殊字符
     **/
    String MESSAGE_CLIENT_ERROR_USERNAME_INCLUDE_SPECIAL_CHARACTER = "用户名包含特殊字符";
    /**
     * @Description: 校验码输入错误
     **/
    String MESSAGE_CLIENT_ERROR_CODE_CHECK_FAILED = "校验码输入错误";
    /**
     * @Description: 短信校验码输入错误
     **/
    String MESSAGE_CLIENT_ERROR_SMS_CHECK_FAILED = "短信校验码输入错误";
    /**
     * @Description: 用户证件异常
     **/
    String MESSAGE_CLIENT_ERROR_ID_CARD = "用户证件异常";
    /**
     * @Description: 用户证件类型未选择
     **/
    String MESSAGE_CLIENT_ERROR_ID_CARD_NO_CHOOSE = "用户证件类型未选择";
    /**
     * @Description: 大陆身份证编号校验非法
     **/
    String MESSAGE_CLIENT_ERROR_ID_CARD_ILLEGAL_VERIFY = "大陆身份证编号校验非法";
    /**
     * @Description: 用户基本信息校验失败
     **/
    String MESSAGE_CLIENT_ERROR_INFO_CHECK_FAILED = "用户基本信息校验失败";
    /**
     * @Description: 手机格式校验失败
     **/
    String MESSAGE_CLIENT_ERROR_INFO_PHONE_CHECK_FAILED = "手机格式校验失败";
    /**
     * @Description: 手机号码与当前绑定不符
     **/
    String MESSAGE_CLIENT_ERROR_INFO_PHONE_CHECK_BIND_NO = "手机号码与当前绑定不符";
    /**
     * @Description: 地址格式校验失败
     **/
    String MESSAGE_CLIENT_ERROR_INFO_ADDRESS_CHECK_FAILED = "地址格式校验失败";
    /**
     * @Description: 邮箱格式校验失败
     **/
    String MESSAGE_CLIENT_ERROR_INFO_EMAIL_CHECK_FAILED = "邮箱格式校验失败";
    /**
     * @Description: 交易密码校验失败
     **/
    String MESSAGE_CLIENT_ERROR_INFO_TRANSACTION_PIN_CHECK_FAILED = "交易密码校验失败";
    /**
     * @Description: 交易密码两次输入不一致
     **/
    String MESSAGE_CLIENT_ERROR_INFO_TRANSACTION_PIN_CHECK_AGAIN = "交易密码两次输入不一致";
    /**
     * @Description: 绑定失败，此手机号已绑定其他账号
     **/
    String MESSAGE_CLIENT_ERROR_INFO_PHONE_CHECK_BIND_EXIST = "绑定失败，此手机号已绑定其他账号";
    /**
     * @Description: 用户登陆异常
     **/
    String MESSAGE_CLIENT_ERROR_LOGIN = "用户登陆异常";
    /**
     * @Description: 用户账户不存在
     **/
    String MESSAGE_CLIENT_ERROR_LOGIN_NO_EXISTS = "用户账户不存在";
    /**
     * @Description: 用户账户被冻结
     **/
    String MESSAGE_CLIENT_ERROR_LOGIN_NO_ACTIVE = "用户账户被冻结";
    /**
     * @Description: 用户账户已作废
     **/
    String MESSAGE_CLIENT_ERROR_LOGIN_DELETE = "用户账户已作废";
    /**
     * @Description: 小程序登录code为空
     **/
    String MESSAGE_CLIENT_ERROR_LOGIN_MINI_APP_CODE_EMPTY = "小程序登录code为空";
    /**
     * @Description: 小程序获取用户信息校验失败
     **/
    String MESSAGE_CLIENT_ERROR_LOGIN_MINI_APP_USER_CHECK_FAILED = "小程序获取用户信息校验失败";

    /**
     * @Description: 用户身份校验失败
     **/
    String MESSAGE_CLIENT_ERROR_IDENTITY = "用户身份校验失败";
    /**
     * @Description: 用户未获得第三方登陆授权
     **/
    String MESSAGE_CLIENT_ERROR_IDENTITY_NO_THIRD_AUTHORIZE = "用户未获得第三方登陆授权";
    /**
     * @Description: 访问权限异常
     **/
    String MESSAGE_CLIENT_ERROR_PERMISSION = "访问权限异常";
    /**
     * @Description: 访问未授权
     **/
    String MESSAGE_CLIENT_ERROR_PERMISSION_NO = "访问未授权";
    /**
     * @Description: 正在授权中
     **/
    String MESSAGE_CLIENT_ERROR_PERMISSION_ING = "正在授权中";
    /**
     * @Description: 用户授权申请被拒绝
     **/
    String MESSAGE_CLIENT_ERROR_PERMISSION_REJECT = "用户授权申请被拒绝";
    /**
     * @Description: 因访问对象隐私设置被拦截
     **/
    String MESSAGE_CLIENT_ERROR_REJECT = "因访问对象隐私设置被拦截";
    /**
     * @Description: 授权已过期
     **/
    String MESSAGE_CLIENT_ERROR_REJECT_TIMEOUT = "授权已过期";

    String MESSAGE_CLIENT_ERROR_REQUEST_HEADER_NOT_FOUND = "未找到请求头";
    /**
     * @Description: 已在其他设备登录
     **/
    String MESSAGE_CLIENT_OTHER_LOGIN = "已在其他设备登录";
    /**
     * @Description: 无权限使用 API
     **/
    String MESSAGE_CLIENT_ERROR_REJECT_NO_PERMISSION = "无权限使用 API";
    /**
     * @Description: 用户访问被拦截
     **/
    String MESSAGE_CLIENT_ERROR_INTERCEPT = "用户访问被拦截";
    /**
     * @Description: 黑名单用户
     **/
    String MESSAGE_CLIENT_ERROR_INTERCEPT_BLACK = "黑名单用户";
    /**
     * @Description: 账号被冻结
     **/
    String MESSAGE_CLIENT_ERROR_INTERCEPT_DELETE = "账号被冻结";
    /**
     * @Description: 非法 IP 地址
     **/
    String MESSAGE_CLIENT_ERROR_INTERCEPT_IP_ILLEGAL = "非法 IP 地址";
    /**
     * @Description: 网关访问受限
     **/
    String MESSAGE_CLIENT_ERROR_INTERCEPT_GATEWAY_LIMIT = "网关访问受限";
    /**
     * @Description: 用户请求参数校验异常
     **/
    String MESSAGE_CLIENT_ERROR_PARAMS = "用户请求参数校验异常";
    /**
     * @Description: 包含非法恶意跳转链接
     **/
    String MESSAGE_CLIENT_ERROR_PARAMS_ILLEGAL_URL = "包含非法恶意跳转链接";
    /**
     * @Description: 无效的用户输入
     **/
    String MESSAGE_CLIENT_ERROR_PARAMS_INVALID_INPUT = "无效的用户输入";
    /**
     * @Description: 请求必填参数为空
     **/
    String MESSAGE_CLIENT_ERROR_PARAMS_EMPTY_MUST = "请求必填参数为空";
    /**
     * @Description: 用户订单号为空
     **/
    String MESSAGE_CLIENT_ERROR_PARAMS_ORDER_EMPTY = "用户订单号为空";
    /**
     * @Description: 订购数量为空
     **/
    String MESSAGE_CLIENT_ERROR_PARAMS_NUM_EMPTY = "订购数量为空";
    /**
     * @Description: 缺少时间戳参数
     **/
    String MESSAGE_CLIENT_ERROR_PARAMS_TIMESTAMP_NULL = "缺少时间戳参数";
    /**
     * @Description: 非法的时间戳参数
     **/
    String MESSAGE_CLIENT_ERROR_PARAMS_TIMESTAMP_ILLEGAL = "非法的时间戳参数";
    /**
     * @Description: 用户请求服务异常
     **/
    String MESSAGE_CLIENT_ERROR_REQUEST = "用户请求服务异常";
    /**
     * @Description: 用户请求方法错误
     **/
    String MESSAGE_CLIENT_ERROR_REQUEST_METHOD = "用户请求方法错误";
    /**
     * @Description: 用户上传文件异常
     **/
    String MESSAGE_CLIENT_ERROR_UPLOAD = "用户上传文件异常";
    /**
     * @Description: 用户上传文件类型不匹配
     **/
    String MESSAGE_CLIENT_ERROR_UPLOAD_TYPE = "用户上传文件类型不匹配";
    /**
     * @Description: 用户上传文件太大
     **/
    String MESSAGE_CLIENT_ERROR_UPLOAD_FILE_SIZE = "用户上传文件太大";
    /**
     * @Description: 用户上传图片太大
     **/
    String MESSAGE_CLIENT_ERROR_UPLOAD_IMAGE_SIZE = "用户上传图片太大";
    /**
     * @Description: 用户上传视频太大
     **/
    String MESSAGE_CLIENT_ERROR_UPLOAD_VIDEO_SIZE = "用户上传视频太大";
    /**
     * @Description: 非虚拟用户不得删除
     **/
    String MESSAGE_CLIENT_ERROR_NOT_FICTITIOUS = "非虚拟用户不得删除";
    /**
     * @Description: 交易问题
     **/
    String MESSAGE_CLIENT_ERROR_PAYMENT = "交易问题";
    /**
     * @Description: 已处理过或已经过期
     **/
    String MESSAGE_CLIENT_ERROR_PAYMENT_COMPLETE = "已处理过或已经过期";
    /**
     * @Description: 金额不相符
     **/
    String MESSAGE_CLIENT_ERROR_PAYMENT_PRICE_DIFFERENT = "金额不相符";
    /**
     * @Description: 第三方支付接口报错
     **/
    String MESSAGE_CLIENT_ERROR_PAYMENT_THIRD_API = "第三方支付接口报错";
    /**
     * @Description: 不支持的支付方式
     **/
    String MESSAGE_CLIENT_ERROR_PAYMENT_NO_PAYMENT = "不支持的支付方式";

    /**
     * @Description: 订单问题
     **/
    String MESSAGE_CLIENT_ERROR_ORDER = "订单问题";
    /**
     * @Description: 库存不足
     **/
    String MESSAGE_CLIENT_ERROR_ORDER_NO_STOCK = "库存不足";
    /**
     * @Description: 超出PUL兑换设定上限
     **/
    String MESSAGE_CLIENT_ERROR_ORDER_TOP_OVERSTEP = "超出PUL兑换设定上限";
    /**
     * @Description: PUL余额不足
     **/
    String MESSAGE_CLIENT_ERROR_ORDER_PUL_NOT_ENOUGH = "PUL余额不足";
    /**
     * @Description: 不需要支付的订单
     **/
    String MESSAGE_CLIENT_ERROR_PAYMENT_NOT_NEED_PAYMENT = "不需要支付的订单";

    /**
     * @Description: 优惠券问题
     **/
    String MESSAGE_CLIENT_ERROR_COUPON = "优惠券问题";

    /**
     * @Description: 优惠券类型异常
     **/
    String MESSAGE_CLIENT_ERROR_COUPON_TYPE = "优惠券类型异常";

    //服务端异常

    /**
     * @Description: 系统执行出错
     **/
    String MESSAGE_SERVICE_ERROR_EXEC = "系统执行出错";
    /**
     * @Description: 服务运行SQLException异常
     **/
    String MESSAGE_SERVICE_ERROR_EXEC_SQL = "服务运行SQLException异常";
}
