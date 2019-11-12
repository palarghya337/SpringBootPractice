package com.practice.springboot.exceptions;

public class InvalidOperationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidOperationException() {
		super();
	}
	public InvalidOperationException(String message) {
		super(message);
	}
	public InvalidOperationException(Throwable exception) {
		super(exception);
	}
	public InvalidOperationException(String message, Throwable exception) {
		super(message, exception);
	}
}
