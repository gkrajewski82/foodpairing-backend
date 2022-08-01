package com.kodilla.foodpairingbackend.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DrinkIngredientDto {

    private Long id;
    private String name;
    private String measure;
    private Long drinkId;
}
