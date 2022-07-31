package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.DishDto;
import com.kodilla.foodpairingbackend.domain.entity.Dish;
import com.kodilla.foodpairingbackend.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DishMapper {

    private final CompositionMapper compositionMapper;

    public Dish mapToDish(DishDto dishDto) throws DrinkNotFoundException, DishNotFoundException,
            CompositionNotFoundException, CommentNotFoundException {
        Dish dish = Dish.builder()
                .id(dishDto.getId())
                .externalSystemId(dishDto.getExternalSystemId())
                .name(dishDto.getName())
                .readyInMinutes(dishDto.getReadyInMinutes())
                .servings(dishDto.getServings())
                .recipeUrl(dishDto.getRecipeUrl())
                .compositionList(compositionMapper.mapToCompositionList(dishDto.getCompositionList()))
                .build();
        return dish;
    }

    public DishDto mapToDishDto(Dish dish) {
        DishDto dishDto = DishDto.builder()
                .id(dish.getId())
                .externalSystemId(dish.getExternalSystemId())
                .name(dish.getName())
                .readyInMinutes(dish.getReadyInMinutes())
                .servings(dish.getServings())
                .recipeUrl(dish.getRecipeUrl())
                .compositionList(compositionMapper.mapToCompositionDtoList(dish.getCompositionList()))
                .build();
        return dishDto;
    }

    public List<DishDto> mapToDishDtoList(final List<Dish> dishList) {
        return dishList.stream()
                .map(this::mapToDishDto)
                .collect(Collectors.toList());
    }
}
