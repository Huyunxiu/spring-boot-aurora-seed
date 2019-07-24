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

	public Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Result(ResultCode resultCode) {
		this.code = resultCode.getCode();
		this.msg = resultCode.getMessage();
	}

	public Result(ResultCode resultCode, T data) {
		this.code = resultCode.getCode();
		this.msg = resultCode.getMessage();
		this.data = data;
	}

    public static Result success() {
        return new Result(ResultCode.SUCCESS);
    }

    public static<T> Result<T> success(T data) {
		return new Result<>(ResultCode.SUCCESS, data);
    }

	public static<T> Result<T> failure(ResultCode resultCode) {
		return new Result<>(resultCode);
	}

	public static<T> Result<T> failure(ResultCode resultCode, T data) {
		return new Result<>(resultCode, data);
	}

	public static<T> Result<T> failure(String errorMessage) {
		return new Result<>(ResultCode.FAIL.getCode(), errorMessage);
	}

	public static<T> Result<T> failure(String errorMessage, T data) {
		return new Result<>(ResultCode.FAIL.getCode(), errorMessage, data);
	}

	public static Result failure() {
		return new Result<>(ResultCode.FAIL);
	}

	public static<T> Result<T> failure(T data) {
		return new Result<>(ResultCode.FAIL, data);
	}
}
