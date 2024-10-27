package com.mokoko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mokoko.entities.Rating;
import com.mokoko.enums.RatedEntityType;

public interface RatingRepository extends JpaRepository<Rating, Long> {
   
     Double findAverageRatingByEntityIdAndType( String id, RatedEntityType type);
}

