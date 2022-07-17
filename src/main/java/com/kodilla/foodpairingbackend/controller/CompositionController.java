package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.domain.dto.CompositionDto;
import com.kodilla.foodpairingbackend.exception.CompositionNotFoundException;
import com.kodilla.foodpairingbackend.service.CompositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodpairing/v1/compositions")
@RequiredArgsConstructor
public class CompositionController {

    private final CompositionService compositionService;

    @GetMapping
    public ResponseEntity<List<CompositionDto>> getComposition() {
        return ResponseEntity.ok(compositionService.getCompositions());
    }

    @GetMapping(value = "{compositionId}")
    public ResponseEntity<CompositionDto> getComposition(@PathVariable Long compositionId) throws CompositionNotFoundException {
        return ResponseEntity.ok(compositionService.getComposition(compositionId));
    }

    @DeleteMapping(value = "{compositionId}")
    public ResponseEntity<Void> deleteComposition(@PathVariable Long compositionId) {
        compositionService.deleteComposition(compositionId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompositionDto> createComposition(@RequestBody CompositionDto compositionDto) {
        return ResponseEntity.ok(compositionService.saveComposition(compositionDto));
    }

    @PutMapping
    public ResponseEntity<CompositionDto> updateComposition(@RequestBody CompositionDto compositionDto) {
        return ResponseEntity.ok(compositionService.saveComposition(compositionDto));
    }
}
