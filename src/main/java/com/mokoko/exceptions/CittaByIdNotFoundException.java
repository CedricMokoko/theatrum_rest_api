package com.mokoko.exceptions;

public class CittaByIdNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CittaByIdNotFoundException(String id) {
		super("La citta con id ''"+id+"'' non è stata trovata.");
	}

}
