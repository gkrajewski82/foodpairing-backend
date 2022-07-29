package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.domain.dto.CommentDto;
import com.kodilla.foodpairingbackend.domain.entity.Comment;
import com.kodilla.foodpairingbackend.exception.CommentNotFoundException;
import com.kodilla.foodpairingbackend.exception.CompositionNotFoundException;
import com.kodilla.foodpairingbackend.mapper.CommentMapper;
import com.kodilla.foodpairingbackend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodpairing/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @GetMapping
    public ResponseEntity<List<CommentDto>> getComments() {
        List<Comment> commentList = commentService.getComments();
        return ResponseEntity.ok(commentMapper.mapToCommentDtoList(commentList));
    }

    @GetMapping(value = "{compositionId}")
    public ResponseEntity<List<CommentDto>> getCommentsForComposition(@PathVariable Long compositionId) {
        List<Comment> commentList = commentService.getCommentsForComposition(compositionId);
        return ResponseEntity.ok(commentMapper.mapToCommentDtoList(commentList));
    }

    @DeleteMapping(value = "{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto) throws CompositionNotFoundException,
            CommentNotFoundException {
        Comment comment = commentMapper.mapToComment(commentDto);
        Comment savedComment = commentService.saveComment(comment);
        return ResponseEntity.ok(commentMapper.mapToCommentDto(savedComment));
    }

    @PutMapping
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto) throws CompositionNotFoundException, CommentNotFoundException {
        Comment comment = commentMapper.mapToComment(commentDto);
        Comment savedComment = commentService.saveComment(comment);
        return ResponseEntity.ok(commentMapper.mapToCommentDto(savedComment));
    }
}
