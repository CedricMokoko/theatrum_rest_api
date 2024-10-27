package com.mokoko.exceptions;

public class SpettacoloByTitoloNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public SpettacoloByTitoloNotFoundException(String titolo) {
		super("Lo spetttacolo ''"+titolo+"'' non è stato trovato.");
	}

}
