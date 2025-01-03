package com.mokoko.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mokoko.entities.Cliente;

/*I repository sono l'interfaccia tra l'applicazione e il database. In Spring, 
 * puoi creare repository estendendo JpaRepository, che fornisce i metodi di 
 * base per le operazioni CRUD.*/

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	//Qui vanno definiti metodi personalizzati
	
	Optional<Cliente> findByEmail(String email);
	
	// Metodo per contare tutti i clienti
    long count();
}
