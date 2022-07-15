package com.kodilla.foodpairingbackend.domain.dto;

import com.kodilla.foodpairingbackend.domain.entity.Composition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DishDto {

    private Long id;
    private Long externalSystemId;
    private String name;
    private int readyInMinutes;
    private int servings;
    private String recipeUrl;
    private List<CompositionDto> composition;
}
