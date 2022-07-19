package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.domain.dto.RatingDto;
import com.kodilla.foodpairingbackend.domain.entity.Rating;
import com.kodilla.foodpairingbackend.exception.CommentNotFoundException;
import com.kodilla.foodpairingbackend.mapper.RatingMapper;
import com.kodilla.foodpairingbackend.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodpairing/v1/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;
    private final RatingMapper ratingMapper;

    @GetMapping
    public ResponseEntity<List<RatingDto>> getRatings() {
        List<Rating> ratingList = ratingService.getRatings();
        return ResponseEntity.ok(ratingMapper.mapToRatingDtoList(ratingList));
    }

    @DeleteMapping(value = "{ratingId}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long ratingId) {
        ratingService.deleteRating(ratingId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RatingDto> createRating(@RequestBody RatingDto ratingDto) throws CommentNotFoundException {
        Rating rating = ratingMapper.mapToRating(ratingDto);
        Rating savedRating = ratingService.saveRating(rating);
        return ResponseEntity.ok(ratingMapper.mapToRatingDto(savedRating));
    }

    @PutMapping
    public ResponseEntity<RatingDto> updateRating(@RequestBody RatingDto ratingDto) throws CommentNotFoundException {
        Rating rating = ratingMapper.mapToRating(ratingDto);
        Rating savedRating = ratingService.saveRating(rating);
        return ResponseEntity.ok(ratingMapper.mapToRatingDto(savedRating));
    }
}
