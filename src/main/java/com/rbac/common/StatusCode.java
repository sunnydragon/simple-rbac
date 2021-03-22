package com.rbac.common;

public enum StatusCode {

    Success(0, "操作成功"),
    RegisteredSuccess(0, "注册成功"),
    LoginSuccess(0, "登录成功"),
    LoginFailure(10000, "用户不存在或者密码错误"),

    NeedLogin(1, "用户没有登录或超时,请重新登录"),

    Unauthorized(401, "权限不足"),

    TokenError(4001,"token错误"),


    IllegalArgument(1000, "参数错误");


    private String desc;

    private int code;

    StatusCode(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }
}
