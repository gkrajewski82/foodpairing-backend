package com.kodilla.foodpairingbackend.service;

import com.kodilla.foodpairingbackend.domain.entity.Rating;
import com.kodilla.foodpairingbackend.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;

    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    public void deleteRating(final Long ratingId) {
        ratingRepository.deleteById(ratingId);
    }

    public Rating saveRating(final Rating rating) {
        return ratingRepository.save(rating);
    }
}
