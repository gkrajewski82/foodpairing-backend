package com.kodilla.foodpairingbackend.repository;

import com.kodilla.foodpairingbackend.domain.entities.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
}
