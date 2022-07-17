package com.kodilla.foodpairingbackend.service;

import com.kodilla.foodpairingbackend.domain.dto.CompositionDto;
import com.kodilla.foodpairingbackend.domain.entity.Composition;
import com.kodilla.foodpairingbackend.exception.CompositionNotFoundException;
import com.kodilla.foodpairingbackend.mapper.CompositionMapper;
import com.kodilla.foodpairingbackend.repository.CompositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompositionService {

    private final CompositionRepository compositionRepository;
    private final CompositionMapper compositionMapper;

    public List<CompositionDto> getCompositions() {
        List<Composition> compositionList = compositionRepository.findAll();
        return compositionMapper.mapToCompositionDtoList(compositionList);
    }

    public CompositionDto getComposition(final Long compositionId) throws CompositionNotFoundException {
        Composition composition = compositionRepository.findById(compositionId).orElseThrow(CompositionNotFoundException::new);
        return compositionMapper.mapToCompositionDto(composition);
    }

    public void deleteComposition(final Long compositionId) {
        compositionRepository.deleteById(compositionId);
    }

    public CompositionDto saveComposition(final CompositionDto compositionDto) {
        Composition composition = compositionMapper.mapToComposition(compositionDto);
        Composition savedComposition = compositionRepository.save(composition);
        return compositionMapper.mapToCompositionDto(savedComposition);
    }
}
