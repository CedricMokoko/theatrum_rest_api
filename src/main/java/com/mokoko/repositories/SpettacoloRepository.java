package com.mokoko.repositories;

import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;

import com.mokoko.entities.Spettacolo;
import com.mokoko.entities.Teatro;

/*I repository sono l'interfaccia tra l'applicazione e il database. In Spring, 
 * puoi creare repository estendendo JpaRepository, che fornisce i metodi di 
 * base per le operazioni CRUD.*/
public interface SpettacoloRepository extends JpaRepository<Spettacolo, String> {
	//Qui vanno definiti metodi personalizzati
	
	List<Spettacolo> findByTitoloContainingIgnoreCase(String titolo);
	
	List<Spettacolo> findByTeatro(Teatro teatro);
}