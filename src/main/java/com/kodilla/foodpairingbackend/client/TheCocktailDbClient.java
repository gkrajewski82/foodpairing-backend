package com.kodilla.foodpairingbackend.client;

import com.kodilla.foodpairingbackend.config.TheCocktailDbConfig;
import com.kodilla.foodpairingbackend.domain.dto.TheCocktailDbResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class TheCocktailDbClient {

    private final RestTemplate restTemplate;
    private final TheCocktailDbConfig theCocktailDbConfig;

    public TheCocktailDbResultDto getRandomDrinkFromExternalApiDb() {
        URI url = UriComponentsBuilder
                .fromHttpUrl(theCocktailDbConfig.getTheCocktailDbEndpoint() + theCocktailDbConfig.getTheCocktailDbKey() + "/random.php")
                .build()
                .encode()
                .toUri();

        TheCocktailDbResultDto apiResponse = restTemplate.getForObject(url, TheCocktailDbResultDto.class);
        return apiResponse;
    }
}
