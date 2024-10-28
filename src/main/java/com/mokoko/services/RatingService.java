package com.mokoko.services;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mokoko.entities.Cliente;
import com.mokoko.entities.Rating;
import com.mokoko.enums.RatedEntityType;
import com.mokoko.exceptions.ClienteByIdNotFoundException;
import com.mokoko.repositories.ClienteRepository;
import com.mokoko.repositories.RatingRepository;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Rating addOrUpdateRating(Long clientId, String entityId, RatedEntityType type, Integer ratingValue) {
        // Controlla se esiste una valutazione per lo stesso cliente e teatro
        Rating rating = ratingRepository.findByClienteIdAndRatedEntityId(clientId, entityId)
            .orElseGet(() -> {
                // Se non esiste, crea una nuova valutazione
                Cliente cliente = clienteRepository.findById(clientId)
                    .orElseThrow(() -> new ClienteByIdNotFoundException(clientId));
                Rating newRating = new Rating();
                newRating.setCliente(cliente);
                newRating.setRatedEntityId(entityId);
                newRating.setRatedEntityType(type);
                return newRating;
            });

        // Aggiorna il valore della valutazione (sia per nuove che esistenti)
        rating.setRatingValue(ratingValue);
        rating.setCreatedAt(LocalDateTime.now());
        return ratingRepository.save(rating);
    }

    public Double getAverageRating(String entityId) {
        return ratingRepository.findAverageRatingByRatedEntityId(entityId);
    }
    
    public Double getAverageRating(String entityId, RatedEntityType type) {
        return ratingRepository.findAverageRatingByRatedEntityIdAndRatedEntityType(entityId, type);
    }
}
