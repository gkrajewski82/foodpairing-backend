package com.kodilla.foodpairingbackend.service;

import com.kodilla.foodpairingbackend.domain.dto.CommentDto;
import com.kodilla.foodpairingbackend.domain.entity.Comment;
import com.kodilla.foodpairingbackend.exception.CommentNotFoundException;
import com.kodilla.foodpairingbackend.mapper.CommentMapper;
import com.kodilla.foodpairingbackend.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public List<CommentDto> getComments() {
        List<Comment> commentList = commentRepository.findAll();
        return commentMapper.mapToCommentDtoList(commentList);
    }

    public CommentDto getComment(final Long commentId) throws CommentNotFoundException {
        Comment comment = commentRepository.findById(commentId).orElseThrow(CommentNotFoundException::new);
        return commentMapper.mapToCommentDto(comment);
    }

    public void deleteComment(final Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public CommentDto saveComment(final CommentDto commentDto) {
        Comment comment = commentMapper.mapToComment(commentDto);
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.mapToCommentDto(savedComment);
    }
}
