package com.kodilla.foodpairingbackend.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class TheCocktailDbConfig {

    @Value("${thecocktaildb.api.freekey}")
    private String theCocktailDbEndpoint;

    @Value("${thecocktaildb.api.endpoint.prod}")
    private String theCocktailDbKey;
}
