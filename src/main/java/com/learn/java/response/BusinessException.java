package com.learn.java.response;

import lombok.Getter;

import java.text.MessageFormat;

@Getter
public class BusinessException extends RuntimeException {
    private ResponseCodeEnum exceptionCodeEnum;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
        this.exceptionCodeEnum = ResponseCodeEnum.FAILED_CODE;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.exceptionCodeEnum = ResponseCodeEnum.FAILED_CODE;
    }

    public BusinessException(String pattern, Object... parameters) {
        this(ResponseCodeEnum.FAILED_CODE, pattern, parameters);
    }

    public BusinessException(ResponseCodeEnum exceptionCodeEnum) {
        super(exceptionCodeEnum.getDesc());
        this.exceptionCodeEnum = exceptionCodeEnum;
    }

    public BusinessException(ResponseCodeEnum exceptionCodeEnum, String pattern, Object... parameters) {
        super(MessageFormat.format(pattern, parameters));
        this.exceptionCodeEnum = exceptionCodeEnum;
    }
}
