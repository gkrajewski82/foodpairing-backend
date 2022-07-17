package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.domain.dto.DishDto;
import com.kodilla.foodpairingbackend.exception.DishNotFoundException;
import com.kodilla.foodpairingbackend.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodpairing/v1/dishes")
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;

    @GetMapping(value = "{dishId}")
    public ResponseEntity<DishDto> getDish(@PathVariable Long dishId) throws DishNotFoundException {
        return ResponseEntity.ok(dishService.getDish(dishId));
    }

    @DeleteMapping(value = "{dishId}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long dishId) {
        dishService.deleteDish(dishId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DishDto> saveDishInDb(@RequestBody DishDto dishDto) {
        return ResponseEntity.ok(dishService.saveDish(dishDto));
    }

    @PutMapping
    public ResponseEntity<DishDto> updateDish(@RequestBody DishDto dishDto) {
        return ResponseEntity.ok(dishService.saveDish(dishDto));
    }
}
