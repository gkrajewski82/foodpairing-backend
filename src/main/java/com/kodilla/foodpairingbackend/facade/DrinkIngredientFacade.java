package com.kodilla.foodpairingbackend.facade;

import com.kodilla.foodpairingbackend.domain.dto.DrinkIngredientDto;
import com.kodilla.foodpairingbackend.domain.entity.DrinkIngredient;
import com.kodilla.foodpairingbackend.exception.DrinkNotFoundException;
import com.kodilla.foodpairingbackend.mapper.DrinkIngredientMapper;
import com.kodilla.foodpairingbackend.service.DrinkIngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DrinkIngredientFacade {

    private final DrinkIngredientService drinkIngredientService;
    private final DrinkIngredientMapper drinkIngredientMapper;

    public List<DrinkIngredientDto> getDrinkIngredients() {
        List<DrinkIngredient> drinkIngredientList = drinkIngredientService.getDrinkIngredients();
        return drinkIngredientMapper.mapToDrinkIngredientDtoList(drinkIngredientList);
    }

    public List<DrinkIngredientDto> getDrinkIngredientsForDrink(Long drinkId) {
        List<DrinkIngredient> drinkIngredientList = drinkIngredientService.getDrinkIngredientsForDrink(drinkId);
        return drinkIngredientMapper.mapToDrinkIngredientDtoList(drinkIngredientList);
    }

    public void deleteDrinkIngredient(Long drinkIngredientId) {
        drinkIngredientService.deleteDrinkIngredient(drinkIngredientId);
    }

    public DrinkIngredientDto saveDrinkIngredient(DrinkIngredientDto drinkIngredientDto) throws DrinkNotFoundException {
        DrinkIngredient drinkIngredient = drinkIngredientMapper.mapToDrinkIngredient(drinkIngredientDto);
        DrinkIngredient savedDrinkIngredient = drinkIngredientService.saveDrinkIngredient(drinkIngredient);
        return drinkIngredientMapper.mapToDrinkIngredientDto(savedDrinkIngredient);
    }

    public DrinkIngredientDto updateDrinkIngredient(DrinkIngredientDto drinkIngredientDto) throws DrinkNotFoundException {
        DrinkIngredient drinkIngredient = drinkIngredientMapper.mapToDrinkIngredient(drinkIngredientDto);
        DrinkIngredient savedDrinkIngredient = drinkIngredientService.saveDrinkIngredient(drinkIngredient);
        return drinkIngredientMapper.mapToDrinkIngredientDto(savedDrinkIngredient);
    }
}
