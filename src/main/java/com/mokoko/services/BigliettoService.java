package com.mokoko.services;

import java.util.List;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mokoko.entities.Biglietto;
import com.mokoko.entities.Cliente;
import com.mokoko.entities.Replica;

import com.mokoko.exceptions.BigliettoByIdNotFoundException;
import com.mokoko.exceptions.ClienteByIdNotFoundException;
import com.mokoko.exceptions.ReplicaByIdNotFoundException;

import com.mokoko.repositories.BigliettoRepository;
import com.mokoko.repositories.ClienteRepository;
import com.mokoko.repositories.ReplicaRepository;



/*I service contengono la logica di business dell'applicazione. Qui puoi definire metodi per 
 * gestire le operazioni sui dati, chiamando i metodi del repository.*/

@Service
public class BigliettoService {
	
	@Autowired
	private BigliettoRepository bigliettoRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private ReplicaRepository replicaRepo;
	
	public List<Biglietto> getAllBiglietti(){
		return bigliettoRepo.findAll();
	}
	
	public Biglietto getBigliettoById(Long id) {
		 Optional<Biglietto> optBiglietto = bigliettoRepo.findById(id);
	     if (optBiglietto.isEmpty()) {
	         throw new BigliettoByIdNotFoundException(id);
	     }
	     return optBiglietto.get();	
	}
	
	public Biglietto createBiglietto(Biglietto biglietto) {
		return bigliettoRepo.save(biglietto);
	}
	
	public void deleteBiglietto(Long id) {
		Optional<Biglietto> bigliettoToDelete = bigliettoRepo.findById(id);
		if(bigliettoToDelete.isEmpty()){
	            throw new BigliettoByIdNotFoundException(id);
		}   
		bigliettoRepo.delete(bigliettoToDelete.get());
	}
	
	public Biglietto updateBiglietto(Long id, Biglietto updatedBiglietto) {
        Biglietto existingBiglietto = bigliettoRepo.findById(id)
        		.orElseThrow(() -> new BigliettoByIdNotFoundException(id));
        
            // Aggiorna i campi del biglietto esistente con i nuovi valori
            existingBiglietto.setDataOra(updatedBiglietto.getDataOra());
            existingBiglietto.setTipoPagamento(updatedBiglietto.getTipoPagamento());
            existingBiglietto.setQuantita(updatedBiglietto.getQuantita());
            existingBiglietto.setReplica(updatedBiglietto.getReplica());
           
            // Salvataggio il biglietto aggiornato
            return bigliettoRepo.save(existingBiglietto); 
    }
	
	// Metodi personalizzati
	
	public List<Biglietto> getBigliettiByReplica(String id){
		Replica replica = replicaRepo.findById(id)
				.orElseThrow(() -> new ReplicaByIdNotFoundException(id));
		
		return bigliettoRepo.findByReplica(replica);	
	}
	
	public List<Biglietto> getBigliettiByCliente(Long id){
		Cliente cliente = clienteRepo.findById(id)
				.orElseThrow(() -> new ClienteByIdNotFoundException(id));
		
		return bigliettoRepo.findByCliente(cliente);
	}
	
	 
}
