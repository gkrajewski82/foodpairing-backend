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
    private final ReactionMapper reactionMapper;

    public Comment mapToComment(final CommentDto commentDto) throws CompositionNotFoundException, CommentNotFoundException {
        Comment comment = Comment.builder()
                .id(commentDto.getId())
                .description(commentDto.getDescription())
                .created(commentDto.getCreated())
                .composition(compositionService.getComposition(commentDto.getCompositionId()))
                .reactionList(reactionMapper.mapToReactionList(commentDto.getReactionList()))
                .build();
        return comment;
    }

    public CommentDto mapToCommentDto(final Comment comment) {
        CommentDto commentDto = CommentDto.builder()
                .id(comment.getId())
                .description(comment.getDescription())
                .created(comment.getCreated())
                .compositionId(comment.getComposition().getId())
                .reactionList(reactionMapper.mapToReactionDtoList(comment.getReactionList()))
                .build();
        return commentDto;
    }

    public List<Comment> mapToCommentList(final List<CommentDto> commentDtoList) throws CompositionNotFoundException,
            CommentNotFoundException {
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
