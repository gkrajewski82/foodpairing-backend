package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.FoodCompositionDto;
import com.kodilla.foodpairingbackend.domain.entities.FoodComposition;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodCompositionMapper {

    private UserMapper userMapper;
    private DrinkMapper drinkMapper;
    private CommentMapper commentMapper;

    public FoodComposition mapToFoodComposition(final FoodCompositionDto foodCompositionDto) {
        return new FoodComposition(
                foodCompositionDto.getId(),
                foodCompositionDto.getExternalSystemDishId(),
                foodCompositionDto.getDishName(),
                foodCompositionDto.getReadyInMinutes(),
                foodCompositionDto.getServings(),
                foodCompositionDto.getDishRecipeUrl(),
                userMapper.mapToUser(foodCompositionDto.getUser()),
                drinkMapper.mapToDrink(foodCompositionDto.getDrink()),
                commentMapper.mapToCommentList(foodCompositionDto.getCommentList())
        );
    }

    public FoodCompositionDto mapToFoodCompositionDto(final FoodComposition foodComposition) {
        return new FoodCompositionDto(
                foodComposition.getId(),
                foodComposition.getExternalSystemDishId(),
                foodComposition.getDishName(),
                foodComposition.getReadyInMinutes(),
                foodComposition.getServings(),
                foodComposition.getDishRecipeUrl(),
                userMapper.mapToUserDto(foodComposition.getUser()),
                drinkMapper.mapToDrinkDto(foodComposition.getDrink()),
                commentMapper.mapToCommentDtoList(foodComposition.getCommentList())
        );
    }

    public List<FoodComposition> napToFoodCompositionList(final List<FoodCompositionDto> foodCompositionDtoList) {
        return foodCompositionDtoList.stream()
                .map(this::mapToFoodComposition)
                .collect(Collectors.toList());
    }

    public List<FoodCompositionDto> napToFoodCompositionDtoList(final List<FoodComposition> foodCompositionList) {
        return foodCompositionList.stream()
                .map(this::mapToFoodCompositionDto)
                .collect(Collectors.toList());
    }
}
