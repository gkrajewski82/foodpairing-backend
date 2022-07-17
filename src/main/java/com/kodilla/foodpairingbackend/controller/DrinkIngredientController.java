package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.domain.dto.DrinkIngredientDto;
import com.kodilla.foodpairingbackend.exception.DrinkIngredientNotFoundException;
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

    @GetMapping
    public ResponseEntity<List<DrinkIngredientDto>> getDrinkIngredients() {
        return ResponseEntity.ok(drinkIngredientService.getDrinkIngredients());
    }

    @GetMapping(value = "{drinkIngredientId}")
    public ResponseEntity<DrinkIngredientDto> getDrinkIngredient(@PathVariable Long drinkIngredientId) throws DrinkIngredientNotFoundException {
        return ResponseEntity.ok(drinkIngredientService.getDrinkIngredient(drinkIngredientId));
    }

    @DeleteMapping(value = "{drinkIngredientId}")
    public ResponseEntity<Void> deleteDrinkIngredient(@PathVariable Long drinkIngredientId) {
        drinkIngredientService.deleteDrinkIngredient(drinkIngredientId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DrinkIngredientDto> createDrinkIngredient(@RequestBody DrinkIngredientDto drinkIngredientDto) {
        return ResponseEntity.ok(drinkIngredientService.saveDrinkIngredient(drinkIngredientDto));
    }

    @PutMapping
    public ResponseEntity<DrinkIngredientDto> updateDrinkIngredient(@RequestBody DrinkIngredientDto drinkIngredientDto) {
        return ResponseEntity.ok(drinkIngredientService.saveDrinkIngredient(drinkIngredientDto));
    }
}
