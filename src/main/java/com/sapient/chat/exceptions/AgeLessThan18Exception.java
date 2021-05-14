package com.sapient.chat.exceptions;

public class AgeLessThan18Exception extends Exception {
	private String message;

	public AgeLessThan18Exception() {
		message = "Age must be more than 18 years";
	}

	public AgeLessThan18Exception(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "AgeLessThan18Exception [message=" + message + "]";
	}

}
