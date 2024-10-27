package com.mokoko.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// Gestione delle eccezioni del modello Teatro
	
    @ExceptionHandler(TeatroByNameNotFoundException.class)
    public ResponseEntity<String> handleTeatroByNameNotFoundException(TeatroByNameNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    
    @ExceptionHandler(TeatroByIdNotFoundException.class)
    public ResponseEntity<String> handleTeatroByIdNotFoundException(TeatroByIdNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    
    
    
    // Gestione delle eccezioni del modello Spettacolo
    
    @ExceptionHandler(SpettacoloByTitoloNotFoundException.class)
    public ResponseEntity<String> handleSpettacoloByTitoloNotFoundException(SpettacoloByTitoloNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    
    @ExceptionHandler(SpettacoloByIdNotFoundException.class)
    public ResponseEntity<String> handleSpettacoloByIdNotFoundException(SpettacoloByIdNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    
    
    
    // Gestione delle eccezioni del modello Replica
    
    @ExceptionHandler(ReplicaByIdNotFoundException.class)
    public ResponseEntity<String> handleReplicaByIdNotFoundException(ReplicaByIdNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    
    
    
    // Gestione delle eccezioni del modello Cliente
    @ExceptionHandler(ClienteByIdNotFoundException.class)
    public ResponseEntity<String> handleClienteloByIdNotFoundException(ClienteByIdNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<String> handleInvalidCredentialsException(InvalidCredentialsException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
    
    @ExceptionHandler(ClienteEmailAlreadyInUse.class)
    public ResponseEntity<String> handleClienteEmailAlreadyInUse(ClienteEmailAlreadyInUse e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
    
    
    
    // Gestione delle eccezioni del modello Biglietto
    @ExceptionHandler(BigliettoByIdNotFoundException.class)
    public ResponseEntity<String> handleBigliettoByIdNotFoundException(BigliettoByIdNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    
    @ExceptionHandler(InsufficientSeatsException.class)
    public ResponseEntity<String> handleInsufficientSeatsException(InsufficientSeatsException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
}
