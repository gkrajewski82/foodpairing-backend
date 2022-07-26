package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.domain.dto.SpoonacularDishDto;
import com.kodilla.foodpairingbackend.service.SpoonacularService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodpairing/v1/spoonacular/dishes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SpoonacularController {

    private final SpoonacularService spoonacularService;

    @GetMapping(value = "{searchName}")
    public List<SpoonacularDishDto> getDishesFromSpoonacular(@PathVariable String searchName) {
        return spoonacularService.getSpoonacularDishes(searchName);
    }
}
