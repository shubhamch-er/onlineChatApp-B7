package com.sapient.chat.exceptions;

public class EmailNotValidException extends Exception {

	private String message;

	public EmailNotValidException() {
		this.message = "Email is not valid";
	}

	public EmailNotValidException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "EmailNotValidException [message=" + message + "]";
	}

}
