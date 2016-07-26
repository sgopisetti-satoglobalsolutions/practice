package com.anhvurz90.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8621187473304016143L;

	public UserNotFoundException(final String username) {
		super(username);
	}
}
