package com.mokoko.services;

import java.util.List;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mokoko.entities.Replica;
import com.mokoko.entities.Spettacolo;
import com.mokoko.exceptions.ReplicaByIdNotFoundException;
import com.mokoko.exceptions.SpettacoloByIdNotFoundException;
import com.mokoko.repositories.ReplicaRepository;
import com.mokoko.repositories.SpettacoloRepository;

@Service
public class ReplicaService {
	
	@Autowired
	private ReplicaRepository replicaRepo;
	
	@Autowired
	private SpettacoloRepository spettacoloRepo;
	
	public List<Replica> getAllRepliche(){
		return replicaRepo.findAll();
	}
	
	public Replica getReplicaById(String id){
		Optional<Replica> optReplica = replicaRepo.findById(id);
		if(optReplica.isEmpty()) {
			new ReplicaByIdNotFoundException(id);
		}
		return optReplica.get();
	}
	
	@Transactional
	public Replica createReplica(Replica replica) {
		return replicaRepo.save(replica);
	}

	@Transactional
	public void deleteReplica(String id) {
		replicaRepo.deleteById(id);
	}
	
	@Transactional
	public Optional<Replica> updateReplica(String id, Replica updatedReplica){	
		return replicaRepo.findById(id).map(existingReplica -> {
			existingReplica.setData(updatedReplica.getData());
			
			return replicaRepo.save(existingReplica);
		});
	}
	
	
	// Metodi personalizzati
	
	public List<Replica> getReplicheBySpettacolo(String id){
		Spettacolo spettacolo = spettacoloRepo.findById(id)
				.orElseThrow(() -> new SpettacoloByIdNotFoundException(id));
		
		return replicaRepo.findBySpettacolo(spettacolo);
	}
	
	//Methode pour mettre à jour le nombre de postes disponibles après achat
	@Transactional
	public Replica updateReplicaPostiDisponibili(String id, Replica updatedReplica) {
		  Replica existingReplica = replicaRepo.findById(id)
		         .orElseThrow(() -> new ReplicaByIdNotFoundException(id));
		  existingReplica.setPostiDisponibili(updatedReplica.getPostiDisponibili());
		  return replicaRepo.save(existingReplica);
	}

}
