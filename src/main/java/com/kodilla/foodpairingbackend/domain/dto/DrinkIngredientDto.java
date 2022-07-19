package com.kodilla.foodpairingbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DrinkIngredientDto {

    private Long id;
    private String name;
    private String measure;
    private Long drinkId;
}
