package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.DishDto;
import com.kodilla.foodpairingbackend.domain.entity.Dish;
import org.springframework.stereotype.Service;

@Service
public class DishMapper {

    private CompositionMapper compositionMapper;

    public Dish mapToDish(DishDto dishDto) {
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
