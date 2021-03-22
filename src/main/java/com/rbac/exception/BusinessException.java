package com.rbac.exception;


import com.rbac.common.StatusCode;

/**
 * 异常处理
 */
public class BusinessException extends RuntimeException {

    /**
     * 异常码
     */
    private int code;

    private Object value;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(int code, String message, Object value) {
        this(code, message);
        this.value = value;
    }

    public BusinessException(StatusCode statusCode) {
        super(statusCode.getDesc());
        this.code = statusCode.getCode();
    }

    public BusinessException(StatusCode statusCode, Object value) {
        this(statusCode);
        this.value = value;
    }

    public BusinessException(StatusCode statusCodee, Object value, Throwable cause) {
        super(statusCodee.getDesc(), cause);
        this.code = statusCodee.getCode();
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public Object getValue() {
        return value;
    }
}
