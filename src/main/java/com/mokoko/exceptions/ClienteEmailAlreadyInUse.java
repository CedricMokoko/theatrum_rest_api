package com.mokoko.exceptions;

public class ClienteEmailAlreadyInUse extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ClienteEmailAlreadyInUse() {
		super("Email already in use.");
	}
}
