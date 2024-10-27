package com.mokoko.services;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mokoko.entities.Spettacolo;
import com.mokoko.entities.Teatro;
import com.mokoko.exceptions.SpettacoloByIdNotFoundException;
import com.mokoko.exceptions.SpettacoloByTitoloNotFoundException;
import com.mokoko.exceptions.TeatroByIdNotFoundException;
import com.mokoko.repositories.SpettacoloRepository;
import com.mokoko.repositories.TeatroRepository;

@Service
public class SpettacoloService {
	
	@Autowired
	private SpettacoloRepository spettacoloRepo;
	
	@Autowired
	private TeatroRepository teatroRepo;
	
	
	public List<Spettacolo> getAllSpettacoli(){
		return spettacoloRepo.findAll();
	}
	
	public Spettacolo getSpettacoloById(String id){
		Optional<Spettacolo> optSpettacolo = spettacoloRepo.findById(id);
		if (optSpettacolo.isEmpty()) {
			throw new SpettacoloByIdNotFoundException(id);
		}
		return optSpettacolo.get();
	}
	
	@Transactional
	public Spettacolo createSpettacolo(Spettacolo spettacolo) {
		return spettacoloRepo.save(spettacolo);
	}
	
	@Transactional
	public void deleteSpettacolo(String id) {
		Optional<Spettacolo> spettacoloToDelete = spettacoloRepo.findById(id);
		if (spettacoloToDelete.isEmpty()) {
			throw new SpettacoloByIdNotFoundException(id);
		}
		spettacoloRepo.delete(spettacoloToDelete.get());	
	}
	
	@Transactional
	public Spettacolo updateSpettacolo(String id, Spettacolo updatedSpettacolo){
		Spettacolo existingSpettacolo = spettacoloRepo.findById(id)
				.orElseThrow(() -> new SpettacoloByIdNotFoundException(id));
			
		existingSpettacolo.setTitolo(updatedSpettacolo.getTitolo());
		existingSpettacolo.setAutore(updatedSpettacolo.getAutore());
		existingSpettacolo.setRegista(updatedSpettacolo.getRegista());
		existingSpettacolo.setPrezzo(updatedSpettacolo.getPrezzo());
			
		return spettacoloRepo.save(existingSpettacolo);	
	}
	
	
	// Metodi personalizzati
	
	public List<Spettacolo> getSpettacoloByTitolo(String titolo) {
		List<Spettacolo> spettacoli = spettacoloRepo.findByTitoloContainingIgnoreCase(titolo);
		if (spettacoli.isEmpty()) {
			throw new SpettacoloByTitoloNotFoundException(titolo);
		}
		return spettacoli;	
	}
	
	
	public List<Spettacolo> getSpettacoliByTeatro(String id) {
		Teatro teatro = teatroRepo.findById(id)
				.orElseThrow(() -> new TeatroByIdNotFoundException(id));
		return spettacoloRepo.findByTeatro(teatro);				
    }	
}
