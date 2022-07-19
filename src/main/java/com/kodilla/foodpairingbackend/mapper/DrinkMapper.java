package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.DrinkDto;
import com.kodilla.foodpairingbackend.domain.entity.Drink;
import com.kodilla.foodpairingbackend.exception.DrinkNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DrinkMapper {

    private final DrinkIngredientMapper drinkIngredientMapper;

    public Drink mapToDrink(final DrinkDto drinkDto) throws DrinkNotFoundException {
        return new Drink(
                drinkDto.getId(),
                drinkDto.getExternalSystemId(),
                drinkDto.getName(),
                drinkDto.getAlcoholic(),
                drinkDto.getGlass(),
                drinkIngredientMapper.mapToDrinkIngredientList(drinkDto.getDrinkIngredientList())
        );
    }

    public DrinkDto mapToDrinkDto(final Drink drink) {
        return new DrinkDto(
                drink.getId(),
                drink.getExternalSystemId(),
                drink.getName(),
                drink.getAlcoholic(),
                drink.getGlass(),
                drinkIngredientMapper.mapToDrinkIngredientDtoList(drink.getDrinkIngredientList())
        );
    }
}
