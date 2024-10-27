package com.mokoko.exceptions;

public class InsufficientSeatsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InsufficientSeatsException(Integer postiDisponibili) {
		super("Spiacenti, rimangono solo piu ''"+postiDisponibili+"'' ¨posti disponibili");
	}

}
