package com.yangfan.xiang.core;

public class CoreException extends RuntimeException {

	private static final long serialVersionUID = -6631488877504937733L;

	public CoreException() {
	}

	public CoreException(String message) {
		super(message);
	}

	public CoreException(Throwable cause) {
		super(cause);
	}

	public CoreException(String message, Throwable cause) {
		super(message, cause);
	}

}
