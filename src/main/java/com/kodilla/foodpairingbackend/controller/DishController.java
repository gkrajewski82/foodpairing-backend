package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.domain.dto.DishDto;
import com.kodilla.foodpairingbackend.domain.entity.Dish;
import com.kodilla.foodpairingbackend.exception.*;
import com.kodilla.foodpairingbackend.mapper.DishMapper;
import com.kodilla.foodpairingbackend.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodpairing/v1/dishes")
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;
    private final DishMapper dishMapper;

    @GetMapping
    public ResponseEntity<List<DishDto>> getDishes() {
        List<Dish> dishList = dishService.getDishes();
        return ResponseEntity.ok(dishMapper.mapToDishDtoList(dishList));
    }

    @GetMapping(value = "{dishId}")
    public ResponseEntity<DishDto> getDish(@PathVariable Long dishId) throws DishNotFoundException {
        Dish dish = dishService.getDish(dishId);
        return ResponseEntity.ok(dishMapper.mapToDishDto(dish));
    }

    @DeleteMapping(value = "{dishId}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long dishId) {
        dishService.deleteDish(dishId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DishDto> saveDishInDb(@RequestBody DishDto dishDto) throws DrinkNotFoundException,
            DishNotFoundException, CompositionNotFoundException, CommentNotFoundException {
        Dish dish = dishMapper.mapToDish(dishDto);
        Dish savedDish = dishService.saveDish(dish);
        return ResponseEntity.ok(dishMapper.mapToDishDto(savedDish));
    }

    @PutMapping
    public ResponseEntity<DishDto> updateDish(@RequestBody DishDto dishDto) throws DrinkNotFoundException,
            DishNotFoundException, CompositionNotFoundException, CommentNotFoundException {
        Dish dish = dishMapper.mapToDish(dishDto);
        Dish savedDish = dishService.saveDish(dish);
        return ResponseEntity.ok(dishMapper.mapToDishDto(savedDish));
    }
}
