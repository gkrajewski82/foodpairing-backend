package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.client.TheCocktailDbClient;
import com.kodilla.foodpairingbackend.domain.dto.TheCocktailDbResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foodpairing/v1/thecocktaildb/")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TheCocktailDbController {

    private final TheCocktailDbClient theCocktailDbClient;

    @GetMapping("randomdrink")
    public void getDrinkFromTheCocktailDb() {
        TheCocktailDbResultDto theCocktailDbResult = theCocktailDbClient.getRandomDrinkFromExternalApiDb();

        theCocktailDbResult.getResult().forEach(theCocktailDbDrinkDto -> {
            System.out.println(theCocktailDbDrinkDto.getId() + ", " + theCocktailDbDrinkDto.getName() + ", " +
                    theCocktailDbDrinkDto.getAlcoholic() + ", " + theCocktailDbDrinkDto.getGlass());
        });
    }
}
