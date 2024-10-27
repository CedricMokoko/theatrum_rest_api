package com.mokoko.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mokoko.entities.Biglietto;
import com.mokoko.entities.Cliente;
import com.mokoko.entities.Replica;

/*I repository sono l'interfaccia tra l'applicazione e il database. In Spring, 
 * puoi creare repository estendendo JpaRepository, che fornisce i metodi di 
 * base per le operazioni CRUD.*/
public interface BigliettoRepository extends JpaRepository<Biglietto, Long> {
	//Qui vanno definiti metodi personalizzati
	
	List<Biglietto> findByReplica(Replica replica);
	
	List<Biglietto> findByCliente(Cliente cliente);
	
	// Metodo per contare tutti i biglietti
    long count();
    
 // Metodo per contare i biglietti per una specifica replica
    long countByReplica(Replica replica);
	
}
