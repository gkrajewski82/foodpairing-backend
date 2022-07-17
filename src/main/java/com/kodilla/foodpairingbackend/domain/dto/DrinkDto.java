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
    private Long externalSystemId;
    private String name;
    private boolean alcoholic;
    private String glass;
    private List<DrinkIngredientDto> DrinkIngredientList;
}
