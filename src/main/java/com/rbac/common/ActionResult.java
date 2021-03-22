package com.rbac.common;


/**
 * 返回数据
 */
public class ActionResult<T>  {

    private int code;
    private String msg;

    private T data;

    public ActionResult() {
        this.code = 0;
        this.msg = "成功";
    }

    public ActionResult(T data) {
        this.code = 0;
        this.msg = "成功";
        this.data = data;
    }
    public ActionResult(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getDesc();
        this.data = null;
    }
    public ActionResult(StatusCode statusCode, T data) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getDesc();
        this.data = data;
    }

    public ActionResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;

    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}