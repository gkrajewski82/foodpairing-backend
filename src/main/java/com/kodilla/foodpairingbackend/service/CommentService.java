package com.kodilla.foodpairingbackend.service;

import com.kodilla.foodpairingbackend.domain.entity.Comment;
import com.kodilla.foodpairingbackend.exception.CommentNotFoundException;
import com.kodilla.foodpairingbackend.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Comment getComment(final Long commentId) throws CommentNotFoundException {
        return commentRepository.findById(commentId).orElseThrow(CommentNotFoundException::new);
    }

    public void deleteComment(final Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public Comment saveComment(final Comment comment) {
        return commentRepository.save(comment);
    }
}
