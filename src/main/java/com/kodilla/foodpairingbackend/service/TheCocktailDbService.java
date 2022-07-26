package com.kodilla.foodpairingbackend.service;

import com.kodilla.foodpairingbackend.client.TheCocktailDbClient;
import com.kodilla.foodpairingbackend.domain.dto.TheCocktailDbDrinkDto;
import com.kodilla.foodpairingbackend.domain.dto.TheCocktailDbResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheCocktailDbService {

    private final TheCocktailDbClient theCocktailDbClient;

    public List<TheCocktailDbDrinkDto> getTheCocktailDrink() {
        TheCocktailDbResultDto result = theCocktailDbClient.getRandomDrinkFromExternalApiDb();
        return result.getResultList();
    }
}
