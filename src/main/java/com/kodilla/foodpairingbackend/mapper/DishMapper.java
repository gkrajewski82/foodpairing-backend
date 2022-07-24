package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.DishDto;
import com.kodilla.foodpairingbackend.domain.entity.Dish;
import com.kodilla.foodpairingbackend.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishMapper {

    private final CompositionMapper compositionMapper;

    public Dish mapToDish(DishDto dishDto) throws DrinkNotFoundException, DishNotFoundException,
            CompositionNotFoundException, CommentNotFoundException {
        return new Dish(
                dishDto.getId(),
                dishDto.getExternalSystemId(),
                dishDto.getName(),
                dishDto.getReadyInMinutes(),
                dishDto.getServings(),
                dishDto.getRecipeUrl(),
                compositionMapper.mapToCompositionList(dishDto.getComposition())
        );
    }

    public DishDto mapToDishDto(Dish dish) {
        return new DishDto(
                dish.getId(),
                dish.getExternalSystemId(),
                dish.getName(),
                dish.getReadyInMinutes(),
                dish.getServings(),
                dish.getRecipeUrl(),
                compositionMapper.mapToCompositionDtoList(dish.getComposition())
        );
    }
}
