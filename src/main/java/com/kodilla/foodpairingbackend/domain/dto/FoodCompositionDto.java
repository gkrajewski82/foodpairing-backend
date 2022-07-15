package com.kodilla.foodpairingbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FoodCompositionDto {

    private Long id;
    private Long externalSystemDishId;
    private String dishName;
    private int readyInMinutes;
    private int servings;
    private String dishRecipeUrl;
    private UserDto user;
    private DrinkDto drink;
    private List<CommentDto> commentList;
}
