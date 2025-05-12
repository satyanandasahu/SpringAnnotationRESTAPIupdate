package com.example.satya.rest.api.exception;

public class InvalidDataException extends RuntimeException {

	private static final long serialVersionUID = -4883016421768158788L;

	public InvalidDataException(String message) {
        super(message);
    }
}
