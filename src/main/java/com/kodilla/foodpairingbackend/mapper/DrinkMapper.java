package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.DrinkDto;
import com.kodilla.foodpairingbackend.domain.entity.Drink;
import org.springframework.stereotype.Service;

@Service
public class DrinkMapper {

    private DrinkIngredientMapper drinkIngredientMapper;

    public Drink mapToDrink(final DrinkDto drinkDto) {
        return new Drink(
                drinkDto.getId(),
                drinkDto.getExternalSystemId(),
                drinkDto.getName(),
                drinkDto.isAlcoholic(),
                drinkDto.getGlass(),
                drinkIngredientMapper.mapToDrinkIngredientList(drinkDto.getDrinkIngredientList())
        );
    }

    public DrinkDto mapToDrinkDto(final Drink drink) {
        return new DrinkDto(
                drink.getId(),
                drink.getExternalSystemId(),
                drink.getName(),
                drink.isAlcoholic(),
                drink.getGlass(),
                drinkIngredientMapper.mapToDrinkIngredientDtoList(drink.getDrinkIngredientList())
        );
    }
}
