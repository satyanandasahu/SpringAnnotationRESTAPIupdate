package com.example.satya.rest.api.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2942952133862603554L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
