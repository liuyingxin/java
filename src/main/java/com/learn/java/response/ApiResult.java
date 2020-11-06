package com.learn.java.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Collections;

@ApiModel("响应对象")
@Data
public class ApiResult<T> implements Serializable {
    @ApiModelProperty(name = "返回码", value = "响应状态码，22000为成功", notes = "返回码")
    private int code;
    @ApiModelProperty(name = "返回消息", value = "返回消息", notes = "返回消息")
    private String msg;
    @ApiModelProperty(name = "返回数据", value = "业务数据", dataType = "java.lang.Object")
    private T data;


    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data == null ? (T) Collections.EMPTY_LIST : data;
    }

    public ApiResult() {
    }

    public ApiResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ApiResult result(T data) {
        return success(data);
    }

    public static ApiResult success() {
        return new ApiResult(ResponseCodeEnum.SUCCESS_CODE.getValue(), ResponseCodeEnum.SUCCESS_CODE.getDesc(), null);
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<T>(ResponseCodeEnum.SUCCESS_CODE.getValue(), ResponseCodeEnum.SUCCESS_CODE.getDesc(), data);
    }

    public static <T> ApiResult success(String message, T data) {
        return new ApiResult<>(ResponseCodeEnum.SUCCESS_CODE.getValue(), message, data);
    }

    public static <T> ApiResult success(Integer code, String message, T data) {
        return new ApiResult<>(code, message, data);
    }

    public static ApiResult fail(String msg) {
        return new ApiResult(ResponseCodeEnum.FAILED_CODE.getValue(), msg, null);
    }

    public static ApiResult fail(ResponseCodeEnum responseCodeEnum) {
        return new ApiResult(responseCodeEnum.getValue(), responseCodeEnum.getDesc(), null);
    }

    public static ApiResult fail(ResponseCodeEnum responseCodeEnum, String msg) {
        if (StringUtils.isEmpty(msg)) {
            msg = responseCodeEnum.getDesc();
        }
        return new ApiResult(responseCodeEnum.getValue(), msg, "");
    }




}