package com.mokoko.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mokoko.entities.Replica;
import com.mokoko.entities.Spettacolo;

/*I repository sono l'interfaccia tra l'applicazione e il database. In Spring, 
 * puoi creare repository estendendo JpaRepository, che fornisce i metodi di 
 * base per le operazioni CRUD.*/
public interface ReplicaRepository extends JpaRepository<Replica, String> {
	//Qui vanno definiti metodi personalizzati
	
	List<Replica> findBySpettacolo(Spettacolo spettacolo);
}
