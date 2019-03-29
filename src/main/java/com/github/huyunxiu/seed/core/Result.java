package com.github.huyunxiu.seed.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author huyunxiu01@gmail.com
 * @version 1.0.0
 * @since 2019-03-29
 */
@Builder
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private int code;

    private String msg;

    private T data;

    public static Result success(ResultCode resultCode) {
        return new Result()
            .setCode(resultCode.getCode())
            .setMsg(resultCode.getMessage());
    }

    public static<T> Result<T> success(ResultCode resultCode, T data) {
        return new Result()
            .setCode(resultCode.getCode())
            .setMsg(resultCode.getMessage())
            .setData(data);
    }

    public static Result success() {
        return new Result()
            .setCode(ResultCode.SUCCESS.getCode())
            .setMsg(ResultCode.SUCCESS.getMessage());
    }

    public static<T> Result<T> success(T data) {
        return new Result()
            .setCode(ResultCode.SUCCESS.getCode())
            .setMsg(ResultCode.SUCCESS.getMessage())
            .setData(data);
    }

    public static<T> Result<T> failure(ResultCode resultCode) {
        return new Result()
            .setCode(resultCode.getCode())
            .setMsg(resultCode.getMessage());
    }

    public static<T> Result<T> failure(ResultCode resultCode, T data) {
        return new Result()
            .setCode(resultCode.getCode())
            .setMsg(resultCode.getMessage())
            .setData(data);
    }

    public static<T> Result<T> failure(String errorMessage) {
        return new Result()
            .setCode(ResultCode.FAIL.getCode())
            .setMsg(errorMessage);
    }

    public static<T> Result<T> failure(String errorMessage, T data) {
        return new Result()
            .setCode(ResultCode.FAIL.getCode())
            .setMsg(errorMessage)
            .setData(data);
    }

    public static Result failure() {
        return new Result()
            .setCode(ResultCode.FAIL.getCode())
            .setMsg(ResultCode.FAIL.getMessage());
    }

    public static<T> Result<T> failure(T data) {
        return new Result()
            .setCode(ResultCode.FAIL.getCode())
            .setMsg(ResultCode.FAIL.getMessage())
            .setData(data);
    }
}
