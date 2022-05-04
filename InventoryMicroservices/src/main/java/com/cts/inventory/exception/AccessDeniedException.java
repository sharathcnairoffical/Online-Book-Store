package com.cts.inventory.exception;

public class AccessDeniedException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;

	public AccessDeniedException() {
		
	}
	
	public AccessDeniedException(String message) {
		super(message);
	}
}
