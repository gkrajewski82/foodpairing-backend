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
    public SpoonacularResultDto getDishesFromSpoonacular(@PathVariable String searchName) {
        return spoonacularClient.getDishesFromExternalApiDb(searchName);
    }
}
