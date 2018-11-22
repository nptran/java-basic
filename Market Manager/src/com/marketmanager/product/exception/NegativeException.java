package com.marketmanager.product.exception;

public class NegativeException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public NegativeException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	
	

}
