package com.example.microcommon.bean;

/**
 * 统一返回结果枚举类
 */
public enum ResultMsgEnum {
    SUCCESS(0, "成功"),
    FAIL(-1, "失败"),
    PARAMS_NOT_NULL(501, "参数不能为空!"),
    AUTH_ERROR(502, "授权失败!"),
    SERVER_BUSY(503, "服务器正忙，请稍后再试!"),
    DATABASE_OPERATION_FAILED(504, "数据库操作失败"),
    USERNAME_NOT_FOUND(505, "数据库操作失败"),
    PASSWORD_IS_WRONG(505, "密码不正确"),
    ;
    private int code;
    private String message;

    ResultMsgEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
