package com.sapient.exceptions;

public class NameTooSmallException {
	private String message;

	public NameTooSmallException() {
		this.message = "Name Too Small Exception"; 
	}
	
	public NameTooSmallException(String message) {
		this.message = message; 
	}

	@Override
	public String toString() {
		return "NameTooSmallException [message=" + message + "]";
	}
	
	
}
