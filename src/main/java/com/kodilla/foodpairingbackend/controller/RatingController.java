package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.domain.dto.RatingDto;
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

    @GetMapping
    public ResponseEntity<List<RatingDto>> getRatings() {
        return ResponseEntity.ok(ratingService.getRatings());
    }

    @DeleteMapping(value = "{ratingId}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long ratingId) {
        ratingService.deleteRating(ratingId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RatingDto> createRating(@RequestBody RatingDto ratingDto) {
        return ResponseEntity.ok(ratingService.saveRating(ratingDto));
    }

    @PutMapping
    public ResponseEntity<RatingDto> updateRating(@RequestBody RatingDto ratingDto) {
        return ResponseEntity.ok(ratingService.saveRating(ratingDto));
    }
}
