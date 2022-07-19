package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.CommentDto;
import com.kodilla.foodpairingbackend.domain.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentMapper {

    private CompositionMapper compositionMapper;
    private RatingMapper ratingMapper;

    public Comment mapToComment(final CommentDto commentDto) {
        return new Comment(
                commentDto.getId(),
                commentDto.getDescription(),
                commentDto.getCreated(),
                compositionMapper.mapToComposition(commentDto.getComposition()),
                ratingMapper.mapToRatingList(commentDto.getRatingList())
        );
    }

    public CommentDto mapToCommentDto(final Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getDescription(),
                comment.getCreated(),
                comment.getComposition().getId(),
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
