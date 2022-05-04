package com.cognizant.exception;

public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException() {
		super();
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}

}
