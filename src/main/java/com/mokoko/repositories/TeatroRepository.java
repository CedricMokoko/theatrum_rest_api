package com.mokoko.repositories;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;

import com.mokoko.entities.Teatro;

/*I repository sono l'interfaccia tra l'applicazione e il database. In Spring, 
 * puoi creare repository estendendo JpaRepository, che fornisce i metodi di 
 * base per le operazioni CRUD.*/
public interface TeatroRepository extends JpaRepository<Teatro, String> {
	//Qui vanno definiti metodi personalizzati
	
	List<Teatro> findByNomeContainingIgnoreCase(String nome);
	
	// Metodo per contare tutti i teatri
    long count();
}
