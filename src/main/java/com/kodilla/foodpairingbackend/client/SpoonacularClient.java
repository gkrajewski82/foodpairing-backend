package com.kodilla.foodpairingbackend.client;

import com.kodilla.foodpairingbackend.config.SpoonacularConfig;
import com.kodilla.foodpairingbackend.domain.dto.SpoonacularResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class SpoonacularClient {

    private final RestTemplate restTemplate;
    private final SpoonacularConfig spoonacularConfig;

    public SpoonacularResultDto getDishesFromExternalApiDb(String searchName) {
        URI url = UriComponentsBuilder
                .fromHttpUrl(spoonacularConfig.getSpoonacularEndpoint() + "/recipes/search")
                .queryParam("apiKey", spoonacularConfig.getSpoonacularKey())
                .queryParam("query", searchName)
                .build()
                .encode()
                .toUri();

        SpoonacularResultDto apiResponse = restTemplate.getForObject(url, SpoonacularResultDto.class);
        return apiResponse;
    }
}
