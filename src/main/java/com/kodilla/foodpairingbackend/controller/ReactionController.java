package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.domain.dto.ReactionDto;
import com.kodilla.foodpairingbackend.domain.entity.Reaction;
import com.kodilla.foodpairingbackend.exception.CommentNotFoundException;
import com.kodilla.foodpairingbackend.mapper.ReactionMapper;
import com.kodilla.foodpairingbackend.service.ReactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodpairing/v1/reactions")
@RequiredArgsConstructor
public class ReactionController {

    private final ReactionService reactionService;
    private final ReactionMapper reactionMapper;

    @GetMapping
    public ResponseEntity<List<ReactionDto>> getReactions() {
        List<Reaction> reactionList = reactionService.getReactions();
        return ResponseEntity.ok(reactionMapper.mapToReactionDtoList(reactionList));
    }

    @GetMapping(value = "{commentId}")
    public ResponseEntity<List<ReactionDto>> getReactionsForComment(@PathVariable Long commentId) {
        List<Reaction> reactionList = reactionService.getReactionsForComment(commentId);
        return ResponseEntity.ok(reactionMapper.mapToReactionDtoList(reactionList));
    }

    @DeleteMapping(value = "{reactionId}")
    public ResponseEntity<Void> deleteReaction(@PathVariable Long reactionId) {
        reactionService.deleteReaction(reactionId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReactionDto> createReaction(@RequestBody ReactionDto reactionDto) throws CommentNotFoundException {
        Reaction reaction = reactionMapper.mapToReaction(reactionDto);
        Reaction savedReaction = reactionService.saveReaction(reaction);
        return ResponseEntity.ok(reactionMapper.mapToReactionDto(savedReaction));
    }

    @PutMapping
    public ResponseEntity<ReactionDto> updateReaction(@RequestBody ReactionDto reactionDto) throws CommentNotFoundException {
        Reaction reaction = reactionMapper.mapToReaction(reactionDto);
        Reaction savedReaction = reactionService.saveReaction(reaction);
        return ResponseEntity.ok(reactionMapper.mapToReactionDto(savedReaction));
    }
}
