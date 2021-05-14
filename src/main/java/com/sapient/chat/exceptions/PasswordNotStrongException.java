package com.sapient.chat.exceptions;

public class PasswordNotStrongException extends Exception {
	private String message;

	public PasswordNotStrongException() {
		message = "Password not strong";
	}

	public PasswordNotStrongException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "PasswordNotStrongException [message=" + message + "]";
	}

}
