package com.kodilla.foodpairingbackend.facade;

import com.kodilla.foodpairingbackend.domain.dto.DrinkDto;
import com.kodilla.foodpairingbackend.domain.entity.Drink;
import com.kodilla.foodpairingbackend.exception.DrinkNotFoundException;
import com.kodilla.foodpairingbackend.mapper.DrinkMapper;
import com.kodilla.foodpairingbackend.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DrinkFacade {

    private final DrinkService drinkService;
    private final DrinkMapper drinkMapper;

    public List<DrinkDto> getDrinks() {
        List<Drink> drinkList = drinkService.getDrinks();
        return drinkMapper.mapToDrinkDtoList(drinkList);
    }

    public DrinkDto getDrink(Long drinkId) throws DrinkNotFoundException {
        Drink drink = drinkService.getDrink(drinkId);
        return drinkMapper.mapToDrinkDto(drink);
    }

    public void deleteDrink(Long drinkId) {
        drinkService.deleteDrink(drinkId);
    }

    public DrinkDto saveDrinkInDb(DrinkDto drinkDto) throws DrinkNotFoundException {
        Drink drink = drinkMapper.mapToDrink(drinkDto);
        Drink savedDrink = drinkService.saveDrink(drink);
        return drinkMapper.mapToDrinkDto(savedDrink);
    }

    public DrinkDto updateDrink(DrinkDto drinkDto) throws DrinkNotFoundException {
        Drink drink = drinkMapper.mapToDrink(drinkDto);
        Drink savedDrink = drinkService.saveDrink(drink);
        return drinkMapper.mapToDrinkDto(savedDrink);
    }
}
