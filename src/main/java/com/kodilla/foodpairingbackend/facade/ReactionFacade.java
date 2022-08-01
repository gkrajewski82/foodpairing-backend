package com.kodilla.foodpairingbackend.facade;

import com.kodilla.foodpairingbackend.domain.dto.ReactionDto;
import com.kodilla.foodpairingbackend.domain.entity.Reaction;
import com.kodilla.foodpairingbackend.exception.CommentNotFoundException;
import com.kodilla.foodpairingbackend.mapper.ReactionMapper;
import com.kodilla.foodpairingbackend.service.ReactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReactionFacade {

    private final ReactionService reactionService;
    private final ReactionMapper reactionMapper;

    public List<ReactionDto> getReactions() {
        List<Reaction> reactionList = reactionService.getReactions();
        return reactionMapper.mapToReactionDtoList(reactionList);
    }

    public List<ReactionDto> getReactionsForComment(Long commentId) {
        List<Reaction> reactionList = reactionService.getReactionsForComment(commentId);
        return reactionMapper.mapToReactionDtoList(reactionList);
    }

    public void deleteReaction(Long reactionId) {
        reactionService.deleteReaction(reactionId);
    }

    public ReactionDto saveReaction(ReactionDto reactionDto) throws CommentNotFoundException {
        Reaction reaction = reactionMapper.mapToReaction(reactionDto);
        Reaction savedReaction = reactionService.saveReaction(reaction);
        return reactionMapper.mapToReactionDto(savedReaction);
    }

    public ReactionDto updateReaction(ReactionDto reactionDto) throws CommentNotFoundException {
        Reaction reaction = reactionMapper.mapToReaction(reactionDto);
        Reaction savedReaction = reactionService.saveReaction(reaction);
        return reactionMapper.mapToReactionDto(savedReaction);
    }
}
