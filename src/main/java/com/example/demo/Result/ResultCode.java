package com.example.demo.Result;


import lombok.Getter;

/**
 * @author jasonccs
 * @date 2021/04/03 10:10
 * @description: 响应码枚举
 */

@Getter
public enum ResultCode {    //1000系列通用错误
    SUCCESS(1000, "操作成功"),
    FAILED(1001, "接口错误"),
    VALIDATE_FAILED(1002, "参数校验失败"),
    ERROR(1003, "未知错误"),
    NO_METHOD_SUPPORT(1004, "请求方法错误"),
    UNSUPPORTED_MEDIA_TYPE(1005, "参数类型错误"),
    URL_NOT_FOUND(1006, "请求的url未找到"),
    //2000系列用户错误
    USER_NOT_EXIST(2000, "用户不存在"),
    USER_LOGIN_FAIL(2001, "用户名或密码错误"),
    USER_NOT_LOGIN(2002, "用户还未登录,请先登录"),
    NO_PERMISSION(2003, "权限不足,请联系管理员");

    private final int code;

    private final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
