package com.mokoko.exceptions;

public class ReplicaByIdNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ReplicaByIdNotFoundException(String id) {
		super("La replica con id ''"+id+"'' non è stata trovata.");
	}
}
