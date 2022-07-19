package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.CommentDto;
import com.kodilla.foodpairingbackend.domain.entity.Comment;
import com.kodilla.foodpairingbackend.exception.CommentNotFoundException;
import com.kodilla.foodpairingbackend.exception.CompositionNotFoundException;
import com.kodilla.foodpairingbackend.service.CompositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentMapper {

    private final CompositionService compositionService;
    private final RatingMapper ratingMapper;

    public Comment mapToComment(final CommentDto commentDto) throws CompositionNotFoundException, CommentNotFoundException {
        return new Comment(
                commentDto.getId(),
                commentDto.getDescription(),
                commentDto.getCreated(),
                compositionService.getComposition(commentDto.getCompositionId()),
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

    public List<Comment> mapToCommentList(final List<CommentDto> commentDtoList) throws CompositionNotFoundException, CommentNotFoundException {
        List<Comment> commentList = new ArrayList<>();
        for (CommentDto commentDto : commentDtoList) {
            Comment comment = mapToComment(commentDto);
            commentList.add(comment);
        }
        return commentList;
    }

    public List<CommentDto> mapToCommentDtoList(final List<Comment> commentList) {
        return commentList.stream()
                .map(this::mapToCommentDto)
                .collect(Collectors.toList());
    }
}
