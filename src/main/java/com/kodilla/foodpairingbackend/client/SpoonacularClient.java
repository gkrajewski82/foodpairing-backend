package com.kodilla.foodpairingbackend.client;

import com.kodilla.foodpairingbackend.config.SpoonacularConfig;
import com.kodilla.foodpairingbackend.domain.dto.DishDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Component
@RequiredArgsConstructor
public class SpoonacularClient {

    private final RestTemplate restTemplate;
    private final SpoonacularConfig spoonacularConfig;

    public List<DishDto> getRecipesFromApi(String searchName) {
        URI url = UriComponentsBuilder
                .fromHttpUrl(spoonacularConfig.getSpoonacularEndpoint() + "/recipes/search")
                .queryParam("apiKey", spoonacularConfig.getSpoonacularKey())
                .queryParam("query", searchName)
                .build()
                .encode()
                .toUri();

        DishDto[] response = restTemplate.getForObject(url, DishDto[].class);
        return Optional.ofNullable(response)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }
}
