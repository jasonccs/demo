package com.example.demo.Result;

import lombok.*;
/**
 * @author jasonccs
 * @date 2021/04/02 15:36
 * @description: 自定义统一响应体
 * VO（ View Object）：显示层对象，通常是Web向模板渲染引擎层传输的对象。
 */
@Getter
@Setter
public class Result<T> {
    /**
     * 状态码，比如1000代表响应成功
     */
    private int code;

    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;

    /**
     * 响应的具体数据
     */
    private T data;

    public Result(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}