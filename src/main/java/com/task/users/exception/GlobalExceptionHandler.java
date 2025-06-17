package com.task.users.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
		log.error("Resource not found: {}", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomErrorResponse("Not Found", ex.getMessage()));
	}

	@ExceptionHandler(DataLoadingException.class)
	public ResponseEntity<CustomErrorResponse> handleDataLoadingException(DataLoadingException ex) {
		log.error("Data loading failed: {}", ex.getMessage());
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
				.body(new CustomErrorResponse("Service Unavailable", ex.getMessage()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustomErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
		String errorMessage = ex.getBindingResult().getAllErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(", "));
		log.error("Validation error: {}", errorMessage);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new CustomErrorResponse("Validation Error", errorMessage));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomErrorResponse> handleGenericException(Exception ex) {
		log.error("Unexpected error: {}", ex.getMessage(), ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new CustomErrorResponse("Internal Server Error", "An unexpected error occurred."));
	}

	@ExceptionHandler(ExternalApiException.class)
	public ResponseEntity<CustomErrorResponse> handleExternalApiException(ExternalApiException ex) {
		log.error("External API error: {}", ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
				.body(new CustomErrorResponse("External API Error", ex.getMessage()));
	}

}
