package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.CompositionDto;
import com.kodilla.foodpairingbackend.domain.entity.Composition;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompositionMapper {

    private UserMapper userMapper;
    private DishMapper dishMapper;
    private DrinkMapper drinkMapper;
    private CommentMapper commentMapper;

    public Composition mapToComposition(final CompositionDto compositionDto) {
        return new Composition(
                compositionDto.getId(),
                userMapper.mapToUser(compositionDto.getUser()),
                dishMapper.mapToDish(compositionDto.getDish()),
                drinkMapper.mapToDrink(compositionDto.getDrink()),
                compositionDto.getCreated(),
                commentMapper.mapToCommentList(compositionDto.getCommentList())
        );
    }

    public CompositionDto mapToCompositionDto(final Composition composition) {
        return new CompositionDto(
                composition.getId(),
                userMapper.mapToUserDto(composition.getUser()),
                dishMapper.mapToDishDto(composition.getDish()),
                drinkMapper.mapToDrinkDto(composition.getDrink()),
                composition.getCreated(),
                commentMapper.mapToCommentDtoList(composition.getCommentList())
        );
    }

    public List<Composition> mapToCompositionList(final List<CompositionDto> compositionDtoList) {
        return compositionDtoList.stream()
                .map(this::mapToComposition)
                .collect(Collectors.toList());
    }

    public List<CompositionDto> mapToCompositionDtoList(final List<Composition> compositionList) {
        return compositionList.stream()
                .map(this::mapToCompositionDto)
                .collect(Collectors.toList());
    }
}
