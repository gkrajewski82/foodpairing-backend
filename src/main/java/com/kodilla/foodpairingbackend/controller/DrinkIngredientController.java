package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.domain.dto.DrinkIngredientDto;
import com.kodilla.foodpairingbackend.exception.DrinkNotFoundException;
import com.kodilla.foodpairingbackend.facade.DrinkIngredientFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodpairing/v1/drinkingredients")
@RequiredArgsConstructor
public class DrinkIngredientController {

    private final DrinkIngredientFacade drinkIngredientFacade;

    @GetMapping
    public ResponseEntity<List<DrinkIngredientDto>> getDrinkIngredients() {
        return ResponseEntity.ok(drinkIngredientFacade.getDrinkIngredients());
    }

    @GetMapping(value = "{drinkId}")
    public ResponseEntity<List<DrinkIngredientDto>> getDrinkIngredientsForDrink(@PathVariable Long drinkId) {
        return ResponseEntity.ok(drinkIngredientFacade.getDrinkIngredientsForDrink(drinkId));
    }

    @DeleteMapping(value = "{drinkIngredientId}")
    public ResponseEntity<Void> deleteDrinkIngredient(@PathVariable Long drinkIngredientId) {
        drinkIngredientFacade.deleteDrinkIngredient(drinkIngredientId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DrinkIngredientDto> createDrinkIngredient(@RequestBody DrinkIngredientDto drinkIngredientDto) throws DrinkNotFoundException {
        return ResponseEntity.ok(drinkIngredientFacade.createDrinkIngredient(drinkIngredientDto));
    }

    @PutMapping
    public ResponseEntity<DrinkIngredientDto> updateDrinkIngredient(@RequestBody DrinkIngredientDto drinkIngredientDto) throws DrinkNotFoundException {
        return ResponseEntity.ok(drinkIngredientFacade.updateDrinkIngredient(drinkIngredientDto));
    }
}
