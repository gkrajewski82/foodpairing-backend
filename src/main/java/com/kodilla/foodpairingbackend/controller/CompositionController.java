package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.domain.dto.CompositionDto;
import com.kodilla.foodpairingbackend.domain.entity.Composition;
import com.kodilla.foodpairingbackend.exception.*;
import com.kodilla.foodpairingbackend.facade.CompositionFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodpairing/v1/compositions")
@RequiredArgsConstructor
public class CompositionController {

    private final CompositionFacade compositionFacade;

    @GetMapping
    public ResponseEntity<List<CompositionDto>> getCompositions() {
        return ResponseEntity.ok(compositionFacade.getCompositions());
    }

    @GetMapping(value = "{compositionId}")
    public ResponseEntity<CompositionDto> getComposition(@PathVariable Long compositionId) throws CompositionNotFoundException {
        return ResponseEntity.ok(compositionFacade.getComposition(compositionId));
    }

    @DeleteMapping(value = "{compositionId}")
    public ResponseEntity<Void> deleteComposition(@PathVariable Long compositionId) {
        compositionFacade.deleteComposition(compositionId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompositionDto> createComposition(@RequestBody CompositionDto compositionDto) throws DrinkNotFoundException,
            DishNotFoundException, CompositionNotFoundException, CommentNotFoundException {
        return ResponseEntity.ok(compositionFacade.createComposition(compositionDto));
    }

    @PutMapping
    public ResponseEntity<CompositionDto> updateComposition(@RequestBody CompositionDto compositionDto) throws DrinkNotFoundException,
            DishNotFoundException, CompositionNotFoundException, CommentNotFoundException {
        return ResponseEntity.ok(compositionFacade.updateComposition(compositionDto));
    }
}
