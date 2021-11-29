package com.example;

import com.example.utils.ErrorCode;

public class CustomException extends Exception{

    private final ErrorCode errorCode;
    private Object data;

    public CustomException(ErrorCode errCode) {
        super(errCode.getMessage());
        this.errorCode = errCode;
    }

    public CustomException(ErrorCode errCode, Object data) {
        super(errCode.getMessage());
        this.errorCode = errCode;
        this.data = data;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
