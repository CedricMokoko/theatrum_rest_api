package com.mokoko.exceptions;

public class TeatroByIdNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TeatroByIdNotFoundException(String id) {
		super("Il teatro con id ''"+id+"'' non è stato trovato.");
	}

}
