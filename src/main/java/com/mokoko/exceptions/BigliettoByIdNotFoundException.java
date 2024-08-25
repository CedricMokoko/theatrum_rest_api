package com.mokoko.exceptions;

public class BigliettoByIdNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BigliettoByIdNotFoundException(Long id) {
		super("il biglieto con id ''"+id+"'' non è stata trovato");
	}
}
