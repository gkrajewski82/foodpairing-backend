package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.RatingDto;
import com.kodilla.foodpairingbackend.domain.entity.Rating;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RatingMapper {

    private final CommentMapper commentMapper;

    public Rating mapToRating(final RatingDto ratingDto) {
        return new Rating(
                ratingDto.getId(),
                ratingDto.getValue(),
                ratingDto.getCreated(),
                commentMapper.mapToComment(ratingDto.getComment())
        );
    }

    public RatingDto mapToRatingDto(final Rating rating) {
        return new RatingDto(
                rating.getId(),
                rating.getValue(),
                rating.getCreated(),
                commentMapper.mapToCommentDto(rating.getComment())
        );
    }

    public List<Rating> mapToRatingList(final List<RatingDto> ratingDtoList) {
        return ratingDtoList.stream()
                .map(this::mapToRating)
                .collect(Collectors.toList());
    }

    public List<RatingDto> mapToRatingDtoList(final List<Rating> ratingList) {
        return ratingList.stream()
                .map(this::mapToRatingDto)
                .collect(Collectors.toList());
    }
}
