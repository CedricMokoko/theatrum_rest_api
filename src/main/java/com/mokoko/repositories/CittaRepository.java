package com.mokoko.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mokoko.entities.Citta;

/*I repository sono l'interfaccia tra l'applicazione e il database. In Spring, 
 * puoi creare repository estendendo JpaRepository, che fornisce i metodi di 
 * base per le operazioni CRUD.*/

@Repository
public interface CittaRepository extends JpaRepository<Citta, String> {
	
	List<Citta> findByNomeContainingIgnoreCase(String nome);
	// Metodo per contare tutte le città
    long count();
}