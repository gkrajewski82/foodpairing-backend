package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.DrinkIngredientDto;
import com.kodilla.foodpairingbackend.domain.dto.TheCocktailDbDrinkDto;
import com.kodilla.foodpairingbackend.domain.entity.Drink;
import com.kodilla.foodpairingbackend.domain.entity.DrinkIngredient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheCocktailDbMapper {

    public Drink mapToDrink(TheCocktailDbDrinkDto theCocktailDbDrinkDto) {
        return new Drink(
                null,
                theCocktailDbDrinkDto.getExternalSystemId(),
                theCocktailDbDrinkDto.getName(),
                theCocktailDbDrinkDto.getAlcoholic(),
                theCocktailDbDrinkDto.getGlass(),
                theCocktailDbDrinkDto.getInstructions(),
                mapToDrinkIngredientList(theCocktailDbDrinkDto)
        );
    }

    public List<DrinkIngredient> mapToDrinkIngredientList(TheCocktailDbDrinkDto theCocktailDbDrinkDto) {
        List<DrinkIngredientDto> ingredientsDto = theCocktailDbDrinkDto.createDrinkIngredientList();
        List<DrinkIngredient> ingredients = null;
        for (DrinkIngredientDto ingredient : ingredientsDto) {
            if (ingredient.getName() != null) {
                ingredients.add(new DrinkIngredient(null, ingredient.getName(), ingredient.getMeasure(), null));
            }
        } return ingredients;
    }
}
