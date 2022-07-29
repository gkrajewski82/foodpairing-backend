package com.kodilla.foodpairingbackend.service;

import com.kodilla.foodpairingbackend.domain.entity.Reaction;
import com.kodilla.foodpairingbackend.repository.ReactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReactionService {

    private final ReactionRepository reactionRepository;

    public List<Reaction> getReactions() {
        return reactionRepository.findAll();
    }

    public void deleteReaction(final Long reactionId) {
        reactionRepository.deleteById(reactionId);
    }

    public Reaction saveReaction(final Reaction reaction) {
        return reactionRepository.save(reaction);
    }
}
