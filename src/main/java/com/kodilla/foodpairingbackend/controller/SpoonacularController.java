package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.client.SpoonacularClient;
import com.kodilla.foodpairingbackend.domain.dto.SpoonacularResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodpairing/v1/spoonacular/dishes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SpoonacularController {

    private final SpoonacularClient spoonacularClient;

    @GetMapping(value = "{searchName}")
    public void getDishesFromSpoonacular(@PathVariable String searchName) {
        SpoonacularResultDto spoonacularResult = spoonacularClient.getDishesFromExternalApiDb(searchName);

        spoonacularResult.getResult().forEach(spoonacularDishDto -> {
            System.out.println(spoonacularDishDto.getId() + ", " + spoonacularDishDto.getId() + ", " +
                    spoonacularDishDto.getName() + ", " + spoonacularDishDto.getReadyInMinutes() +
                    ", " + spoonacularDishDto.getServings() + ", " + spoonacularDishDto.getRecipeUrl());
        });

    }



}
