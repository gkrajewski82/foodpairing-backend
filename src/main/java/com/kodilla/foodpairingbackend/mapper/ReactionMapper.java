package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.ReactionDto;
import com.kodilla.foodpairingbackend.domain.entity.Reaction;
import com.kodilla.foodpairingbackend.exception.CommentNotFoundException;
import com.kodilla.foodpairingbackend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReactionMapper {

    private final CommentService commentService;

    public Reaction mapToReaction(final ReactionDto reactionDto) throws CommentNotFoundException {
        return new Reaction(
                reactionDto.getId(),
                reactionDto.getValue(),
                reactionDto.getCreated(),
                commentService.getComment(reactionDto.getCommentId())
        );
    }

    public ReactionDto mapToReactionDto(final Reaction reaction) {
        return new ReactionDto(
                reaction.getId(),
                reaction.getValue(),
                reaction.getCreated(),
                reaction.getComment().getId()
        );
    }

    public List<Reaction> mapToReactionList(final List<ReactionDto> reactionDtoList) throws CommentNotFoundException {
        List<Reaction> reactionList = new ArrayList<>();
        for (ReactionDto reactionDto : reactionDtoList) {
            Reaction reaction = mapToReaction(reactionDto);
            reactionList.add(reaction);
        }
        return reactionList;
    }

    public List<ReactionDto> mapToReactionDtoList(final List<Reaction> reactionList) {
        return reactionList.stream()
                .map(this::mapToReactionDto)
                .collect(Collectors.toList());
    }
}
