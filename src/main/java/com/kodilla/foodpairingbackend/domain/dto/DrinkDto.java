package com.kodilla.foodpairingbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DrinkDto {

    private Long id;
    private String externalSystemId;
    private String name;
    private String alcoholic;
    private String glass;
    private List<DrinkIngredientDto> drinkIngredientList;
}
