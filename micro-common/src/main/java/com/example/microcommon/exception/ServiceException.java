package com.example.microcommon.exception;

/**
 * @Date 14/9/2022 0014 上午 10:28
 * @Description 自定义异常
 * @Version 1.0.0
 * @Author liwenbo
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
