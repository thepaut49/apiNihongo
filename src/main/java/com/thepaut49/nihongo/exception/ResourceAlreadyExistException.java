package com.thepaut49.nihongo.exception;

public class ResourceAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceAlreadyExistException(String message) {
        super(message);
    }

}
