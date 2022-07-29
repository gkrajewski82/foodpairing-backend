package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.domain.dto.DrinkIngredientDto;
import com.kodilla.foodpairingbackend.domain.entity.DrinkIngredient;
import com.kodilla.foodpairingbackend.exception.DrinkIngredientNotFoundException;
import com.kodilla.foodpairingbackend.exception.DrinkNotFoundException;
import com.kodilla.foodpairingbackend.mapper.DrinkIngredientMapper;
import com.kodilla.foodpairingbackend.service.DrinkIngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodpairing/v1/drinkingredients")
@RequiredArgsConstructor
public class DrinkIngredientController {

    private final DrinkIngredientService drinkIngredientService;
    private final DrinkIngredientMapper drinkIngredientMapper;


    @GetMapping
    public ResponseEntity<List<DrinkIngredientDto>> getDrinkIngredients() {
        List<DrinkIngredient> drinkIngredientList = drinkIngredientService.getDrinkIngredients();
        return ResponseEntity.ok(drinkIngredientMapper.mapToDrinkIngredientDtoList(drinkIngredientList));
    }

    @GetMapping(value = "{drinkId}")
    public ResponseEntity<List<DrinkIngredientDto>> getDrinkIngredientsForDrink(@PathVariable Long drinkId) {
        List<DrinkIngredient> drinkIngredientList = drinkIngredientService.getDrinkIngredientsForDrink(drinkId);
        return ResponseEntity.ok(drinkIngredientMapper.mapToDrinkIngredientDtoList(drinkIngredientList));
    }

    @DeleteMapping(value = "{drinkIngredientId}")
    public ResponseEntity<Void> deleteDrinkIngredient(@PathVariable Long drinkIngredientId) {
        drinkIngredientService.deleteDrinkIngredient(drinkIngredientId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DrinkIngredientDto> createDrinkIngredient(@RequestBody DrinkIngredientDto drinkIngredientDto) throws DrinkNotFoundException {
        DrinkIngredient drinkIngredient = drinkIngredientMapper.mapToDrinkIngredient(drinkIngredientDto);
        DrinkIngredient savedDrinkIngredient = drinkIngredientService.saveDrinkIngredient(drinkIngredient);
        return ResponseEntity.ok(drinkIngredientMapper.mapToDrinkIngredientDto(savedDrinkIngredient));
    }

    @PutMapping
    public ResponseEntity<DrinkIngredientDto> updateDrinkIngredient(@RequestBody DrinkIngredientDto drinkIngredientDto) throws DrinkNotFoundException {
        DrinkIngredient drinkIngredient = drinkIngredientMapper.mapToDrinkIngredient(drinkIngredientDto);
        DrinkIngredient savedDrinkIngredient = drinkIngredientService.saveDrinkIngredient(drinkIngredient);
        return ResponseEntity.ok(drinkIngredientMapper.mapToDrinkIngredientDto(savedDrinkIngredient));
    }
}
