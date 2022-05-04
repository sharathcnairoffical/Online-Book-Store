package com.cts.inventory.exception;

public class BookAlreadyExistException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BookAlreadyExistException() {
		
	}
	public BookAlreadyExistException(String msg) {
		super(msg);
	}
}
