package com.kodilla.foodpairingbackend.service;

import com.kodilla.foodpairingbackend.domain.dto.DrinkDto;
import com.kodilla.foodpairingbackend.domain.entity.Drink;
import com.kodilla.foodpairingbackend.exception.DrinkNotFoundException;
import com.kodilla.foodpairingbackend.mapper.DrinkMapper;
import com.kodilla.foodpairingbackend.repository.DrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DrinkService {

    private final DrinkRepository drinkRepository;
    private final DrinkMapper drinkMapper;

    public DrinkDto getDrink(final Long drinkId) throws DrinkNotFoundException {
        Drink drink = drinkRepository.findById(drinkId).orElseThrow(DrinkNotFoundException::new);
        return drinkMapper.mapToDrinkDto(drink);
    }

    public void deleteDrink(final Long drinkId) {
        drinkRepository.deleteById(drinkId);
    }

    public DrinkDto saveDrink(final DrinkDto drinkDto) {
        Drink drink = drinkMapper.mapToDrink(drinkDto);
        Drink savedDrink = drinkRepository.save(drink);
        return drinkMapper.mapToDrinkDto(savedDrink);
    }
}
