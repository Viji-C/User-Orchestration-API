package com.task.users.exception;

public class DataLoadingException extends RuntimeException {

	private static final long serialVersionUID = -458921451794383172L;

	public DataLoadingException(String message) {
		super(message);
	}

	public DataLoadingException(String message, Throwable cause) {
		super(message, cause);
	}
}
