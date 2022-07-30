package com.kodilla.foodpairingbackend.facade;

import com.kodilla.foodpairingbackend.domain.dto.CommentDto;
import com.kodilla.foodpairingbackend.domain.entity.Comment;
import com.kodilla.foodpairingbackend.exception.CommentNotFoundException;
import com.kodilla.foodpairingbackend.exception.CompositionNotFoundException;
import com.kodilla.foodpairingbackend.mapper.CommentMapper;
import com.kodilla.foodpairingbackend.service.CommentService;
import lombok.RequiredArgsConstructor;;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentFacade {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    public List<CommentDto> getComments() {
        List<Comment> commentList = commentService.getComments();
        return commentMapper.mapToCommentDtoList(commentList);
    }

    public List<CommentDto> getCommentsForComposition(Long compositionId) {
        List<Comment> commentList = commentService.getCommentsForComposition(compositionId);
        return commentMapper.mapToCommentDtoList(commentList);
    }

    public void deleteComment(Long commentId) {
        commentService.deleteComment(commentId);
    }

    public CommentDto createComment(CommentDto commentDto) throws CompositionNotFoundException, CommentNotFoundException {
        Comment comment = commentMapper.mapToComment(commentDto);
        Comment savedComment = commentService.saveComment(comment);
        return commentMapper.mapToCommentDto(savedComment);
    }

    public CommentDto updateComment(CommentDto commentDto) throws CompositionNotFoundException, CommentNotFoundException {
        Comment comment = commentMapper.mapToComment(commentDto);
        Comment savedComment = commentService.saveComment(comment);
        return commentMapper.mapToCommentDto(savedComment);
    }
}
