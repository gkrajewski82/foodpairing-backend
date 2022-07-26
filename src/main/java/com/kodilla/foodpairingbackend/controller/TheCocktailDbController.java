package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.domain.dto.TheCocktailDbDrinkDto;
import com.kodilla.foodpairingbackend.service.TheCocktailDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/foodpairing/v1/thecocktaildb/")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TheCocktailDbController {

    private final TheCocktailDbService theCocktailDbService;

    @GetMapping("randomdrink")
    public List<TheCocktailDbDrinkDto> getRandomDrinkFromTheCocktailDb() {
        return theCocktailDbService.getTheCocktailDrink();
    }
}
