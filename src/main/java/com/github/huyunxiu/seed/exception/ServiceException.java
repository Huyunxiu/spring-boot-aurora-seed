package com.github.huyunxiu.seed.exception;

import com.github.huyunxiu.seed.core.ResultCode;

/**
 * @author huyunxiu01@gmail.com
 * @since 2019-03-29
 */
public class ServiceException extends RuntimeException {

	private Integer errorCode;

	public ServiceException() {
	}

	public ServiceException(String message) {
		super(message);
		errorCode = -1;
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		errorCode = -1;
	}

	public ServiceException(Integer errorCode, String message) {
		super(message);
		setErrorCode(errorCode);
	}

	public ServiceException(Integer errorCode, String message, Throwable cause) {
		super(message, cause);
		setErrorCode(errorCode);
	}

	public ServiceException(ResultCode resultCode, String message) {
		super(resultCode.getMessage());
		setErrorCode(resultCode.getCode());
	}

	public ServiceException(ResultCode resultCode, String message, Throwable cause) {
		super(resultCode.getMessage(), cause);
		setErrorCode(resultCode.getCode());
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
}
