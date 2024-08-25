package com.mokoko.exceptions;

public class ClienteByIdNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ClienteByIdNotFoundException(Long id) {
		super("il cliente con id ''"+id+"'' non è stata trovato");
	}
}
