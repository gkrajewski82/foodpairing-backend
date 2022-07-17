package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.domain.dto.DrinkDto;
import com.kodilla.foodpairingbackend.exception.DrinkNotFoundException;
import com.kodilla.foodpairingbackend.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodpairing/v1/drinks")
@RequiredArgsConstructor
public class DrinkController {

    private final DrinkService drinkService;

    @GetMapping(value = "{drinkId}")
    public ResponseEntity<DrinkDto> getDrink(@PathVariable Long drinkId) throws DrinkNotFoundException {
        return ResponseEntity.ok(drinkService.getDrink(drinkId));
    }

    @DeleteMapping(value = "{drinkId}")
    public ResponseEntity<Void> deleteDrink(@PathVariable Long drinkId) {
        drinkService.deleteDrink(drinkId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DrinkDto> saveDrinkInDb(@RequestBody DrinkDto drinkDto) {
        return ResponseEntity.ok(drinkService.saveDrink(drinkDto));
    }

    @PutMapping
    public ResponseEntity<DrinkDto> updateDrink(@RequestBody DrinkDto drinkDto) {
        return ResponseEntity.ok(drinkService.saveDrink(drinkDto));
    }
}
