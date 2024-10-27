package com.mokoko.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mokoko.entities.Citta;
import com.mokoko.exceptions.CittaByIdNotFoundException;
import com.mokoko.exceptions.CittaByNameNotFoundException;
import com.mokoko.repositories.CittaRepository;

@Service
public class CittaService {

    @Autowired
    private CittaRepository cittaRepo;

    public List<Citta> getAllCittas() {
        return cittaRepo.findAll();
    }

    public Citta getCittaById(String id) {
        Optional<Citta> optCitta = cittaRepo.findById(id);

        if (optCitta.isEmpty()) {
            throw new CittaByIdNotFoundException(id);
        }
        return optCitta.get();
    }

    public List<Citta> getCittaByNome(String nome) {
        List<Citta> cittaList = cittaRepo.findByNomeContainingIgnoreCase(nome);
        
        // Se la lista è vuota, lancia un'eccezione
        if (cittaList.isEmpty()) {
            throw new CittaByNameNotFoundException(nome);
        }
        
        // Restituisce le città trovate
        return cittaList;
    }

    @Transactional
    public Citta createCitta(Citta citta) {
        return cittaRepo.save(citta);
    }

    @Transactional
    public void deleteCitta(String id) {
        Optional<Citta> cittaToDelete = cittaRepo.findById(id);
        if (cittaToDelete.isEmpty()) {
            throw new CittaByIdNotFoundException(id);
        }
        cittaRepo.delete(cittaToDelete.get());
    }

    @Transactional
    public Citta updateCitta(String id, Citta updatedCitta) {
        Citta existingCitta = cittaRepo.findById(id)
                .orElseThrow(() -> new CittaByIdNotFoundException(id));

        existingCitta.setNome(updatedCitta.getNome());
        existingCitta.setDescription(updatedCitta.getDescription());
        existingCitta.setImageUrl(updatedCitta.getImageUrl());
        existingCitta.setRatings(updatedCitta.getRatings());

        return cittaRepo.save(existingCitta);
    }
}
