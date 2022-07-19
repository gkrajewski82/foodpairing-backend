package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.RatingDto;
import com.kodilla.foodpairingbackend.domain.entity.Rating;
import com.kodilla.foodpairingbackend.exception.CommentNotFoundException;
import com.kodilla.foodpairingbackend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RatingMapper {

    private final CommentService commentService;

    public Rating mapToRating(final RatingDto ratingDto) throws CommentNotFoundException {
        return new Rating(
                ratingDto.getId(),
                ratingDto.getValue(),
                ratingDto.getCreated(),
                commentService.getComment(ratingDto.getCommentId())
        );
    }

    public RatingDto mapToRatingDto(final Rating rating) {
        return new RatingDto(
                rating.getId(),
                rating.getValue(),
                rating.getCreated(),
                rating.getComment().getId()
        );
    }

    public List<Rating> mapToRatingList(final List<RatingDto> ratingDtoList) throws CommentNotFoundException {
        List<Rating> ratingList = new ArrayList<>();
        for (RatingDto ratingDto : ratingDtoList) {
            Rating rating = mapToRating(ratingDto);
            ratingList.add(rating);
        }
        return ratingList;
    }

    public List<RatingDto> mapToRatingDtoList(final List<Rating> ratingList) {
        return ratingList.stream()
                .map(this::mapToRatingDto)
                .collect(Collectors.toList());
    }
}
