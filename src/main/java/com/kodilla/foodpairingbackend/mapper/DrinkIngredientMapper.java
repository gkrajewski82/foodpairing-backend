package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.DrinkIngredientDto;
import com.kodilla.foodpairingbackend.domain.entity.DrinkIngredient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DrinkIngredientMapper {

    private DrinkMapper drinkMapper;

    public DrinkIngredient mapToDrinkIngredient(final DrinkIngredientDto drinkIngredientDto) {
        return new DrinkIngredient(
                drinkIngredientDto.getId(),
                drinkIngredientDto.getName(),
                drinkIngredientDto.getMeasure(),
                drinkMapper.mapToDrink(drinkIngredientDto.getDrink())
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

    public List<DrinkIngredient> mapToDrinkIngredientList(final List<DrinkIngredientDto> drinkIngredientDtoList) {
        return drinkIngredientDtoList.stream()
                .map(this::mapToDrinkIngredient)
                .collect(Collectors.toList());
    }
    public List<DrinkIngredientDto> mapToDrinkIngredientDtoList(final List<DrinkIngredient> drinkIngredientList) {
        return drinkIngredientList.stream()
                .map(this::mapToDrinkIngredientDto)
                .collect(Collectors.toList());
    }
}
