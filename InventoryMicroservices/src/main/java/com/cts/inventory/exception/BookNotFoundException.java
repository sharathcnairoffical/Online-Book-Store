package com.cts.inventory.exception;

public class BookNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookNotFoundException() {
		
	}
	
	public BookNotFoundException(String msg) {
		super(msg);
	}
}
