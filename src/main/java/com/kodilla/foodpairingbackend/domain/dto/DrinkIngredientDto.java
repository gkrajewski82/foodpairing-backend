package com.kodilla.foodpairingbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
public class DrinkIngredientDto {

    private Long id;
    private String name;
    private String measure;
    private Long drinkId;
}
