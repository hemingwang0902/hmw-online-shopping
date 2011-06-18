package com.baizhi.exception;

public class BaizhiException extends RuntimeException {

	private static final long serialVersionUID = 5926809964703175839L;

	public BaizhiException() {
		super();

	}

	public BaizhiException(String message, Throwable cause) {
		super(message, cause);

	}

	public BaizhiException(String message) {
		super(message);

	}

	public BaizhiException(Throwable cause) {
		super(cause);

	}

}
