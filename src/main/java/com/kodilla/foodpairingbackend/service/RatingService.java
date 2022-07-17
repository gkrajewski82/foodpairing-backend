package com.kodilla.foodpairingbackend.service;

import com.kodilla.foodpairingbackend.domain.dto.RatingDto;
import com.kodilla.foodpairingbackend.domain.entity.Rating;
import com.kodilla.foodpairingbackend.mapper.RatingMapper;
import com.kodilla.foodpairingbackend.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    public List<RatingDto> getRatings() {
        List<Rating> ratingList = ratingRepository.findAll();
        return ratingMapper.mapToRatingDtoList(ratingList);
    }

    public void deleteRating(final Long ratingId) {
        ratingRepository.deleteById(ratingId);
    }

    public RatingDto saveRating(final RatingDto ratingDto) {
        Rating rating = ratingMapper.mapToRating(ratingDto);
        Rating savedRating = ratingRepository.save(rating);
        return ratingMapper.mapToRatingDto(savedRating);
    }
}
