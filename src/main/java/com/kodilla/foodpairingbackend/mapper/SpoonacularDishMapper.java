package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.SpoonacularDishDto;
import com.kodilla.foodpairingbackend.domain.entity.Dish;
import org.springframework.stereotype.Service;

@Service
public class SpoonacularDishMapper {

    public Dish mapToDish(SpoonacularDishDto spoonacularDishDto) {
        return new Dish(
                null,
                spoonacularDishDto.getExternalSystemId(),
                spoonacularDishDto.getName(),
                spoonacularDishDto.getReadyInMinutes(),
                spoonacularDishDto.getServings(),
                spoonacularDishDto.getRecipeUrl(),
                null
        );
    }
}
