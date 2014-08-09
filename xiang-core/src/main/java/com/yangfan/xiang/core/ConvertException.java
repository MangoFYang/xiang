package com.yangfan.xiang.core;

public class ConvertException extends RuntimeException {

	private static final long serialVersionUID = 705808333081606431L;

	public ConvertException() {
		super();
	}

	public ConvertException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ConvertException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConvertException(String message) {
		super(message);
	}

	public ConvertException(Throwable cause) {
		super(cause);
	}
	
}
