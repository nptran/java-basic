package com.classroommanager.exception;

public class NegativeException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String message;

	public String getMessage() {
		return message.toUpperCase();
	}
	
	public NegativeException(String message) {
		this.message = message;
	}
	

}
