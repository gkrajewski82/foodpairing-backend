package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.domain.dto.ReactionDto;
import com.kodilla.foodpairingbackend.exception.CommentNotFoundException;
import com.kodilla.foodpairingbackend.facade.ReactionFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodpairing/v1/reactions")
@RequiredArgsConstructor
public class ReactionController {

    private final ReactionFacade reactionFacade;

    @GetMapping
    public ResponseEntity<List<ReactionDto>> getReactions() {
        return ResponseEntity.ok(reactionFacade.getReactions());
    }

    @GetMapping(value = "{commentId}")
    public ResponseEntity<List<ReactionDto>> getReactionsForComment(@PathVariable Long commentId) {
        return ResponseEntity.ok(reactionFacade.getReactionsForComment(commentId));
    }

    @DeleteMapping(value = "{reactionId}")
    public ResponseEntity<Void> deleteReaction(@PathVariable Long reactionId) {
        reactionFacade.deleteReaction(reactionId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReactionDto> saveReaction(@RequestBody ReactionDto reactionDto) throws CommentNotFoundException {
        return ResponseEntity.ok(reactionFacade.saveReaction(reactionDto));
    }

    @PutMapping
    public ResponseEntity<ReactionDto> updateReaction(@RequestBody ReactionDto reactionDto) throws CommentNotFoundException {
        return ResponseEntity.ok(reactionFacade.updateReaction(reactionDto));
    }
}
