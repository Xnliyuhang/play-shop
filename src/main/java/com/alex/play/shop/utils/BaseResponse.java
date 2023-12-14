package com.alex.play.shop.utils;


import com.alex.play.shop.constans.CodeConstants;
import com.alex.play.shop.constans.MessageConstants;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName BaseResponse
 * @Description 统一数据返回对象
 * @Author Alex
 * @Date 2023/12/6 11:28
 * @Version 1.0
 */
@Data
@Builder
@Slf4j
public class BaseResponse<T> {
    /**
     * @Description: 返回状态码
     **/
    private int code;

    /**
     * @Description: 基本信息
     **/
    private String message;

    /**
     * @Description: 扩展消息
     **/
    private String extMessage;

    /**
     * @Description: 返回数据
     **/
    private T data;

    public static <T> BaseResponse<T> success(T result) {
        BaseResponse<T> baseResponse = BaseResponse.<T>builder().build();
        baseResponse.setCode(CodeConstants.CODE_OK);
        baseResponse.setMessage(MessageConstants.MESSAGE_OK);
        baseResponse.setData(result);

        return baseResponse;
    }

    public static <T> BaseResponse<T> success(T result, String extMessage) {
        BaseResponse<T> baseResponse = BaseResponse.<T>builder().build();
        baseResponse.setCode(CodeConstants.CODE_OK);
        baseResponse.setMessage(MessageConstants.MESSAGE_OK);
        baseResponse.setData(result);
        baseResponse.setExtMessage(extMessage);

        return baseResponse;
    }

    public static BaseResponse<String> failure(String errorCode, String errorMessage) {
        BaseResponse<String> baseResponse = BaseResponse.<String>builder().build();
        baseResponse.setCode(Integer.parseInt(errorCode));
        baseResponse.setMessage(errorMessage);
        baseResponse.setExtMessage(errorCode + ":" + errorMessage);
        baseResponse.setData(null);

        return baseResponse;
    }

    public static BaseResponse<String> failure(String message) {
        BaseResponse<String> baseResponse = BaseResponse.<String>builder().build();
        baseResponse.setCode(CodeConstants.CODE_SERVICE_ERROR_EXEC);
        baseResponse.setMessage(MessageConstants.MESSAGE_SERVICE_ERROR_EXEC);
        baseResponse.setExtMessage(message);
        baseResponse.setData(null);

        return baseResponse;
    }

    public static <T> BaseResponse<T> failure(Class<T> target, String message) {
        try {
            BaseResponse<T> baseResponse = BaseResponse.<T>builder().build();
            baseResponse.setCode(CodeConstants.CODE_SERVICE_ERROR_EXEC);
            baseResponse.setMessage(MessageConstants.MESSAGE_SERVICE_ERROR_EXEC);
            baseResponse.setExtMessage(message);
            baseResponse.setData(null);
            return baseResponse;
        } catch (Exception e) {
            log.error("【数据转换】数据转换出错，目标对象{}构造函数异常", target.getName(), e);
            return null;
        }
    }

}
