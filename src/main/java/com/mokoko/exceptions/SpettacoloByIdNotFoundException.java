package com.mokoko.exceptions;

public class SpettacoloByIdNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public SpettacoloByIdNotFoundException(String id) {
		super("Lo spettacolo con id ''"+id+"'' non è stato trovato");
	}
}
