package com.example.satya.rest.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApplicationErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
		ApplicationErrorResponse errorResponse = new ApplicationErrorResponse();
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<ApplicationErrorResponse> handleInvalidInputException(InvalidDataException ex) {
		ApplicationErrorResponse errorResponse = new ApplicationErrorResponse();
		errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ApplicationErrorResponse> handleInvalidInputException(ApplicationException ex) {
		ApplicationErrorResponse errorResponse = new ApplicationErrorResponse();
		errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	// Add more exception handlers as needed

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApplicationErrorResponse> handleGenericException(Exception ex) {
		ApplicationErrorResponse errorResponse = new ApplicationErrorResponse();
		errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setMessage("An unexpected error occurred");
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}