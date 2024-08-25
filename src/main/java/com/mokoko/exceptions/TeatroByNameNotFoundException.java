package com.mokoko.exceptions;

/*Ici c'est une exception qui se verifie au RunTime quand
* l'application s'exécute*/
public class TeatroByNameNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TeatroByNameNotFoundException(String nome) {
		super("Il teatro ''"+nome+"'' non è stato trovato.");
	}

}
