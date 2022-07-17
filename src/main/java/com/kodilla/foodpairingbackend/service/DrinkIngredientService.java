package com.kodilla.foodpairingbackend.service;

import com.kodilla.foodpairingbackend.domain.dto.DrinkIngredientDto;
import com.kodilla.foodpairingbackend.domain.entity.DrinkIngredient;
import com.kodilla.foodpairingbackend.exception.DrinkIngredientNotFoundException;
import com.kodilla.foodpairingbackend.mapper.DrinkIngredientMapper;
import com.kodilla.foodpairingbackend.repository.DrinkIngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkIngredientService {

    private final DrinkIngredientRepository drinkIngredientRepository;
    private final DrinkIngredientMapper drinkIngredientMapper;

    public List<DrinkIngredientDto> getDrinkIngredients() {
        List<DrinkIngredient> drinkIngredientList = drinkIngredientRepository.findAll();
        return drinkIngredientMapper.mapToDrinkIngredientDtoList(drinkIngredientList);
    }

    public DrinkIngredientDto getDrinkIngredient(final Long drinkIngredientId) throws DrinkIngredientNotFoundException {
        DrinkIngredient drinkIngredient = drinkIngredientRepository.findById(drinkIngredientId)
                .orElseThrow(DrinkIngredientNotFoundException::new);
        return drinkIngredientMapper.mapToDrinkIngredientDto(drinkIngredient);
    }

    public void deleteDrinkIngredient(final Long drinkIngredientId) {
        drinkIngredientRepository.deleteById(drinkIngredientId);
    }

    public DrinkIngredientDto saveDrinkIngredient(final DrinkIngredientDto drinkIngredientDto) {
        DrinkIngredient drinkIngredient = drinkIngredientMapper.mapToDrinkIngredient(drinkIngredientDto);
        DrinkIngredient savedDrinkIngredient = drinkIngredientRepository.save(drinkIngredient);
        return drinkIngredientMapper.mapToDrinkIngredientDto(savedDrinkIngredient);
    }
}
