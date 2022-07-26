package com.kodilla.foodpairingbackend.service;

import com.kodilla.foodpairingbackend.client.SpoonacularClient;
import com.kodilla.foodpairingbackend.domain.dto.SpoonacularDishDto;
import com.kodilla.foodpairingbackend.domain.dto.SpoonacularResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpoonacularService {

    private final SpoonacularClient spoonacularClient;

    public List<SpoonacularDishDto> getSpoonacularDishes(String nameFragment) {
        SpoonacularResultDto result = spoonacularClient.getDishesFromExternalApiDb(nameFragment);
        return result.getResultList();
    }
}
