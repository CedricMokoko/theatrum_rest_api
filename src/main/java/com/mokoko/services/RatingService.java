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
    private ClienteRepository clienteRepository; // Add a repository for Cliente

    public Rating addRating(Long clientId, String entityId, RatedEntityType type, Integer ratingValue) {
        // Fetch the Cliente by its ID
        Cliente cliente = clienteRepository.findById(clientId)
            .orElseThrow(() -> new ClienteByIdNotFoundException(clientId));

        Rating rating = new Rating();
        rating.setCliente(cliente); // Set the fetched Cliente
        rating.setRatedEntityId(entityId);
        rating.setRatedEntityType(type);
        rating.setRatingValue(ratingValue);
        rating.setCreatedAt(LocalDateTime.now()); // You might want to set the createdAt field too

        return ratingRepository.save(rating);
    }

    public Double getAverageRating(String entityId, RatedEntityType type) {
        return ratingRepository.findAverageRatingByEntityIdAndType(entityId, type);
    }


    // Altri metodi per aggiornare o eliminare rating
}

