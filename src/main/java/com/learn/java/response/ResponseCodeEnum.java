package com.learn.java.response;

import lombok.Getter;

@Getter
public enum ResponseCodeEnum {

    //
    SUCCESS_CODE(22000, "成功"),
    FAILED_CODE(22001, "处理失败"),
    NO_PERMISSION(22002, "没有权限"),
    SYSTEM_EXCEPTION(22003, "系统错误"),
    NOT_FOUND(22005, "URI不存在"),
    PARAMETER_EXCEPTION(22006, "参数错误"),
    ACTION_FREQUENT(22007, "操作过频繁"),
    ILLEGAL_REQUEST(22008, "非法请求"),
    JSON_TRANS_ERROR(22009, "json解析失败"),
    SYSTEM_BLOCK(22010, "操作等待"),
    RESPONSE_ERROR(22011, "返回数据不正确"),
    OUT_SERVICE_ERROR(22012, "外部请求失败"),
    ENV_ERROR(22013, "环境变量有误"),
    SIGNATURE_ERROR(22015, "API签名错误"),
    SIGN_EXPIRE(22016, "签名失效"),
    METHOD_NOT_ALLOWED(22017, "请求方法不支持"),
    NOT_LOGGED_IN(22018, "用户未登录");

    private Integer value;
    private String desc;

    ResponseCodeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
