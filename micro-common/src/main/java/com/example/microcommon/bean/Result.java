package com.example.microcommon.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 统一结果返回类
 *
 * @param <T>
 */
@Data
@Accessors(chain = true)
public class Result<T> {

    private int code;
    private String message;
    private T data;

    public Result() {
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 成功
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.setCode(ResultMsgEnum.SUCCESS.getCode());
        result.setMessage(ResultMsgEnum.SUCCESS.getMessage());
        return result;
    }

    /**
     * 成功
     */
    public static <T> Result<T> success(String message) {
        Result<T> result = new Result<T>();
        result.setCode(ResultMsgEnum.SUCCESS.getCode());
        result.setMessage(message);
        return result;
    }

    /**
     * 成功
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setCode(ResultMsgEnum.SUCCESS.getCode());
        result.setMessage(ResultMsgEnum.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    /**
     * 失败
     */
    public static <T> Result<T> error(int code, String message) {
        return new Result(code, message);
    }

    /**
     * 失败
     */
    public static <T> Result<T> error(ResultMsgEnum resultMsgEnum) {
        return new Result(resultMsgEnum.getCode(), resultMsgEnum.getMessage());
    }
}