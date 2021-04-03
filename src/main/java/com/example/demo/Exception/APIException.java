package com.example.demo.Exception;

import com.example.demo.Result.ResultCode;
import lombok.Getter;

/**
 * @author suruomo
 * @date 2020/8/7 16:43
 * @description: 自定义异常
 */
@Getter
public class APIException extends RuntimeException {
    private final int code;
    private final String msg;

    public APIException() {
        this(ResultCode.FAILED);
    }

    public APIException(ResultCode failed) {
        this.code = failed.getCode();
        this.msg = failed.getMsg();
    }
}
