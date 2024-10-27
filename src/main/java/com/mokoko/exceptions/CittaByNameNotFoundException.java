package com.mokoko.exceptions;

public class CittaByNameNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CittaByNameNotFoundException(String nome) {
		super("La citta ''"+nome+"'' non è stata trovata.");
	}

}