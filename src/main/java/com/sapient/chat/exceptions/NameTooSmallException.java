package com.sapient.chat.exceptions;

public class NameTooSmallException extends Exception{
	private String message;
	
	public NameTooSmallException() {
		message = "Name is too small";
	}
	
	public NameTooSmallException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "NameTooSmallException [message=" + message + "]";
	}
	
}
