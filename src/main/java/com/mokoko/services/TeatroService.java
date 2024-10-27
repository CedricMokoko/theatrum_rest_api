package com.mokoko.services;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mokoko.entities.Teatro;
import com.mokoko.exceptions.TeatroByIdNotFoundException;
import com.mokoko.exceptions.TeatroByNameNotFoundException;
import com.mokoko.repositories.TeatroRepository;

@Service
public class TeatroService {
	
	@Autowired
	private TeatroRepository teatroRepo;
	
	public List<Teatro> getAllTeatri(){
		return teatroRepo.findAll();
	}
	
	public Teatro getTeatroById(String id) {
		 Optional<Teatro> optTeatro = teatroRepo.findById(id);
		 
	     if (optTeatro.isEmpty()) {
	         throw new TeatroByIdNotFoundException(id);
	     }
	     return optTeatro.get();	
	 }
	
	public List<Teatro> getTeatroByNome(String nome) {
		List<Teatro> teatri = teatroRepo.findByNomeContainingIgnoreCase(nome);
		
	    // Se l'Optional è vuoto, lancia un'eccezione
		if(teatri.isEmpty()) {
			throw new TeatroByNameNotFoundException(nome);
		}
		// Se no, restituisce il teatro trovato
		return teatri;
	}
	
	@Transactional
	public Teatro createTeatro(Teatro teatro) {
		return teatroRepo.save(teatro);
	}
	
	@Transactional
	public void deleteTeatro(String id) {
		  Optional<Teatro> teatroToDelete = teatroRepo.findById(id);
	       if(teatroToDelete.isEmpty()){
	            throw new TeatroByIdNotFoundException(id);
	      }   
	      teatroRepo.delete(teatroToDelete.get());
	}
	
	@Transactional
	public Teatro updateTeatro(String id, Teatro updatedTeatro) {
	    Teatro existingTeatro = teatroRepo.findById(id)
	            .orElseThrow(() -> new TeatroByIdNotFoundException(id));

	    existingTeatro.setNome(updatedTeatro.getNome());
	    existingTeatro.setIndirizzo(updatedTeatro.getIndirizzo());
	    existingTeatro.setCitta(updatedTeatro.getCitta());
	    existingTeatro.setProvincia(updatedTeatro.getProvincia());
	    existingTeatro.setTelefono(updatedTeatro.getTelefono());
	    existingTeatro.setPosti(updatedTeatro.getPosti());

	    return teatroRepo.save(existingTeatro);
	}
	
}
