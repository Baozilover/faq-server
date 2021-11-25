package com.example.faqserver.utils;

public enum ErrorCode {

    E00001("00001","用户不存在"),
    E00002("00002","用户已存在");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
