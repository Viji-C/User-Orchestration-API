package com.task.users.exception;

/**
 * Custom exception thrown when an error occurs during external API interaction.
 */
public class ExternalApiException extends RuntimeException {

	private static final long serialVersionUID = 6167240528088950706L;

	public ExternalApiException(String message) {
		super(message);
	}

	public ExternalApiException(String message, Throwable cause) {
		super(message, cause);
	}
}
