package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.CommentDto;
import com.kodilla.foodpairingbackend.domain.entities.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentMapper {

    private FoodCompositionMapper foodCompositionMapper;
    private RatingMapper ratingMapper;

    public Comment mapToComment(final CommentDto commentDto) {
        return new Comment(
                commentDto.getId(),
                commentDto.getDescription(),
                commentDto.getCreated(),
                foodCompositionMapper.mapToFoodComposition(commentDto.getFoodComposition()),
                ratingMapper.mapToRatingList(commentDto.getRatingList())
        );
    }

    public CommentDto mapToCommentDto(final Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getDescription(),
                comment.getCreated(),
                foodCompositionMapper.mapToFoodCompositionDto(comment.getFoodComposition()),
                ratingMapper.mapToRatingDtoList(comment.getRatingList())
        );
    }

    public List<Comment> mapToCommentList(final List<CommentDto> commentDtoList) {
        return commentDtoList.stream()
                .map(this::mapToComment)
                .collect(Collectors.toList());
    }

    public List<CommentDto> mapToCommentDtoList(final List<Comment> commentList) {
        return commentList.stream()
                .map(this::mapToCommentDto)
                .collect(Collectors.toList());
    }
}
