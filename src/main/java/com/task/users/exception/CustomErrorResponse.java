package com.task.users.exception;

public class CustomErrorResponse {
	private String error;
	private String message;

	public CustomErrorResponse(String error, String message) {
		this.error = error;
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}
}
