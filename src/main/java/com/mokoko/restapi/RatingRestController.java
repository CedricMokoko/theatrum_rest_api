package com.mokoko.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mokoko.entities.Rating;
import com.mokoko.enums.RatedEntityType;
import com.mokoko.services.RatingService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Ratings", description = "Endpoint per la gestione dei ratings")
@RestController
@RequestMapping("/api/ratings")
@CrossOrigin(origins = "http://localhost:4200")
public class RatingRestController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> addOrUpdateRating(@RequestParam Long clientId,
                                              @RequestParam String entityId,
                                              @RequestParam RatedEntityType type,
                                              @RequestParam Integer valoreRating) {
        Rating rating = ratingService.addOrUpdateRating(clientId, entityId, type, valoreRating);
        return ResponseEntity.ok(rating);
    }

    @GetMapping("/media/{id}")
    public ResponseEntity<Double> getAverageRating(
            @PathVariable("id") String entityId,
            @RequestParam(required = false) RatedEntityType type) {
        Double media;
        
        if (type != null) {
            // Filtra per ID e tipo
            media = ratingService.getAverageRating(entityId, type);
        } else {
            // Filtra solo per ID
            media = ratingService.getAverageRating(entityId);
        }
        
        return ResponseEntity.ok(media);
    }

}