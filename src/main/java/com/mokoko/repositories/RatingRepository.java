package com.mokoko.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mokoko.entities.Rating;
import com.mokoko.enums.RatedEntityType;

public interface RatingRepository extends JpaRepository<Rating, Long> {
	@Query("SELECT AVG(r.ratingValue) FROM Rating r WHERE r.ratedEntityId = :ratedEntityId")
	Double findAverageRatingByRatedEntityId(@Param("ratedEntityId") String ratedEntityId);

	@Query("SELECT AVG(r.ratingValue) FROM Rating r WHERE r.ratedEntityId = :ratedEntityId AND r.ratedEntityType = :ratedEntityType")
	Double findAverageRatingByRatedEntityIdAndRatedEntityType(@Param("ratedEntityId") String ratedEntityId, @Param("ratedEntityType") RatedEntityType ratedEntityType);
	
	Optional<Rating> findByClienteIdAndRatedEntityId(Long clienteId, String ratedEntityId);
}

