package com.example.pojo;

import com.example.utils.ErrorCode;

public class ReturnResult {
    public String code;
    public String msg;
    public Object data;

    public ReturnResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ReturnResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ReturnResult(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
        this.data = "";
    }

    public ReturnResult(ErrorCode errorCode, Object data) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
        this.data = data;
    }

    public static ReturnResult ok() {
        return new ReturnResult("0", "SUCCESS");
    }

    public static ReturnResult ok(String msg) {
        return new ReturnResult("0", msg);
    }

    public static ReturnResult ok(Object data) {
        return new ReturnResult("0", "SUCCESS", data);
    }

    public static ReturnResult ok(String code, String msg, Object data) {
        return new ReturnResult(code, msg, data);
    }

    public static ReturnResult error() {
        return new ReturnResult("1", "FAILED");
    }

    public static ReturnResult error(String msg) {
        return new ReturnResult("1", msg);
    }

    public static ReturnResult error(Object data) {
        return new ReturnResult("1", "FAILED", data);
    }

    public static ReturnResult error(String code, String msg) {
        return new ReturnResult(code, msg);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}
