package com.mokoko.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mokoko.entities.Biglietto;
import com.mokoko.entities.Cliente;
import com.mokoko.entities.Replica;
import com.mokoko.entities.Teatro;
import com.mokoko.exceptions.BigliettoByIdNotFoundException;
import com.mokoko.exceptions.ClienteByIdNotFoundException;
import com.mokoko.exceptions.InsufficientSeatsException;
import com.mokoko.exceptions.ReplicaByIdNotFoundException;

import com.mokoko.repositories.BigliettoRepository;
import com.mokoko.repositories.ClienteRepository;
import com.mokoko.repositories.ReplicaRepository;



/*I Services contengono la logica di business dell'applicazione. Qui puoi definire metodi per 
 * gestire le operazioni sui dati, chiamando i metodi del repository e/o di altri servizi quando serve.*/

@Service
public class BigliettoService {
	
	@Autowired
	private BigliettoRepository bigliettoRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private ReplicaRepository replicaRepo;
	
	@Autowired
	private ReplicaService replicaService;
	
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
	
	@Transactional // Gestisce la transazione per questa operazione. Se non va tutto bene il database torna allo stato di prima
	public List<Biglietto> createBiglietto(Biglietto biglietto) {
	    // Imposta la data e l'ora correnti per tutti i biglietti
	    biglietto.setDataOra(LocalDateTime.now());
	    
	    Teatro teatroAssociato = biglietto.getReplica().getSpettacolo().getTeatro();
	    
	    int postiDisponibili = biglietto.getReplica().getPostiDisponibili();
	    int quantitaRichiesta = biglietto.getQuantita();
	    
	    // Controlla se ci sono abbastanza posti disponibili
	    if (postiDisponibili < quantitaRichiesta) {
	        throw new InsufficientSeatsException(postiDisponibili);
	    }
	    
	    // Ottieni il numero di biglietti già presenti per la replica specificata
	    long numeroBigliettiGiaPresenti = bigliettoRepo.countByReplica(biglietto.getReplica());
	    
	    // Lista per memorizzare tutti i biglietti creati
	    List<Biglietto> bigliettiCreati = new ArrayList<>();
	    
	    // Creazione dei biglietti in base alla quantità richiesta
	    for (int i = 0; i < quantitaRichiesta; i++) {
	        
	    	Biglietto nuovoBiglietto = new Biglietto();
	        nuovoBiglietto.setDataOra(biglietto.getDataOra());
	        nuovoBiglietto.setTipoPagamento(biglietto.getTipoPagamento());
	        nuovoBiglietto.setQuantita(1); // Ogni biglietto rappresenta un singolo posto
	        nuovoBiglietto.setReplica(biglietto.getReplica());
	        nuovoBiglietto.setCliente(biglietto.getCliente());
	        
	        // Genera il numero del biglietto basato sul numero totale di biglietti già presenti
	        setCodiceOperazioneBiglietto(nuovoBiglietto, teatroAssociato, numeroBigliettiGiaPresenti + i); 
	        
	        // Salva il biglietto nel repository
	        Biglietto bigliettoSalvato = bigliettoRepo.save(nuovoBiglietto);
	        bigliettiCreati.add(bigliettoSalvato); // Add il biglietto salvato nell'Array "bigliettiCreati"
	        
	        // Decrementa i posti disponibili
	        postiDisponibili--;
	        biglietto.getReplica().setPostiDisponibili(postiDisponibili);
	    }	    
	    // Aggiorna il teatro per riflettere i posti disponibili aggiornati
	    replicaService.updateReplicaPostiDisponibili(biglietto.getReplica().getId(), biglietto.getReplica());
	    
	    return bigliettiCreati;
	}

	@Transactional
	public void deleteBiglietto(Long id) {
		Optional<Biglietto> bigliettoToDelete = bigliettoRepo.findById(id);
		if(bigliettoToDelete.isEmpty()){
	            throw new BigliettoByIdNotFoundException(id);
		}   
		bigliettoRepo.delete(bigliettoToDelete.get());
	}
	
	@Transactional
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
	
	@Transactional
	private void setCodiceOperazioneBiglietto(Biglietto biglietto, Teatro teatro, long numeroBigliettiGiaPresenti) {
       
        int bigliettiVenduti = (int) numeroBigliettiGiaPresenti; // Calcola i biglietti già venduti  
        // Calcola la lunghezza del numero del biglietto
        String formato = "%0" + teatro.getPosti().toString().length() + "d";        
        // Incrementa il contatore dei biglietti venduti e formatta il numero
        String numeroBigliettoFormatted = String.format(formato, bigliettiVenduti + 1);
       
        biglietto.setCodOperazione(numeroBigliettoFormatted); // Assegna il numero formattato
    } 
}
