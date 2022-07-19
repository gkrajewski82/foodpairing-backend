package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.domain.dto.CompositionDto;
import com.kodilla.foodpairingbackend.domain.entity.Composition;
import com.kodilla.foodpairingbackend.exception.CompositionNotFoundException;
import com.kodilla.foodpairingbackend.mapper.CompositionMapper;
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
    private final CompositionMapper compositionMapper;

    @GetMapping
    public ResponseEntity<List<CompositionDto>> getComposition() {
        List<Composition> compositionList = compositionService.getCompositions();
        return ResponseEntity.ok(compositionMapper.mapToCompositionDtoList(compositionList));
    }

    @GetMapping(value = "{compositionId}")
    public ResponseEntity<CompositionDto> getComposition(@PathVariable Long compositionId) throws CompositionNotFoundException {
        Composition composition = compositionService.getComposition(compositionId);
        return ResponseEntity.ok(compositionMapper.mapToCompositionDto(composition));
    }

    @DeleteMapping(value = "{compositionId}")
    public ResponseEntity<Void> deleteComposition(@PathVariable Long compositionId) {
        compositionService.deleteComposition(compositionId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompositionDto> createComposition(@RequestBody CompositionDto compositionDto) {
        Composition composition = compositionMapper.mapToComposition(compositionDto);
        Composition savedComposition = compositionService.saveComposition(composition);
        return ResponseEntity.ok(compositionMapper.mapToCompositionDto(savedComposition));
    }

    @PutMapping
    public ResponseEntity<CompositionDto> updateComposition(@RequestBody CompositionDto compositionDto) {
        Composition composition = compositionMapper.mapToComposition(compositionDto);
        Composition savedComposition = compositionService.saveComposition(composition);
        return ResponseEntity.ok(compositionMapper.mapToCompositionDto(savedComposition));
    }
}
