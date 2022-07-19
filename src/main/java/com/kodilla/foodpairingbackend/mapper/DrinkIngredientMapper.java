package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.DrinkIngredientDto;
import com.kodilla.foodpairingbackend.domain.entity.DrinkIngredient;
import com.kodilla.foodpairingbackend.exception.DrinkNotFoundException;
import com.kodilla.foodpairingbackend.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DrinkIngredientMapper {

    private final DrinkService drinkService;

    public DrinkIngredient mapToDrinkIngredient(final DrinkIngredientDto drinkIngredientDto) throws DrinkNotFoundException {
        return new DrinkIngredient(
                drinkIngredientDto.getId(),
                drinkIngredientDto.getName(),
                drinkIngredientDto.getMeasure(),
                drinkService.getDrink(drinkIngredientDto.getDrinkId())
        );
    }

    public DrinkIngredientDto mapToDrinkIngredientDto(final DrinkIngredient drinkIngredient) {
        return new DrinkIngredientDto(
                drinkIngredient.getId(),
                drinkIngredient.getName(),
                drinkIngredient.getMeasure(),
                drinkIngredient.getDrink().getId()
        );
    }

    public List<DrinkIngredient> mapToDrinkIngredientList(final List<DrinkIngredientDto> drinkIngredientDtoList) throws DrinkNotFoundException {
        List<DrinkIngredient> drinkIngredientList = new ArrayList<>();
        for (DrinkIngredientDto drinkIngredientDto : drinkIngredientDtoList) {
            DrinkIngredient drinkIngredient = mapToDrinkIngredient(drinkIngredientDto);
            drinkIngredientList.add(drinkIngredient);
        }
        return drinkIngredientList;
    }

    public List<DrinkIngredientDto> mapToDrinkIngredientDtoList(final List<DrinkIngredient> drinkIngredientList) {
        return drinkIngredientList.stream()
                .map(this::mapToDrinkIngredientDto)
                .collect(Collectors.toList());
    }
}
