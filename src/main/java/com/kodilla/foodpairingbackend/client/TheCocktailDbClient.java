package com.kodilla.foodpairingbackend.client;

import com.kodilla.foodpairingbackend.config.TheCocktailDbConfig;
import com.kodilla.foodpairingbackend.domain.dto.DrinkDto;
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

    public DrinkDto getRandomDrinkFromApi() {
        URI url = UriComponentsBuilder
                .fromHttpUrl(theCocktailDbConfig.getTheCocktailDbEndpoint() +
                        theCocktailDbConfig.getTheCocktailDbKey() + "/random.php")
                .build()
                .encode()
                .toUri();

        DrinkDto apiResponse = restTemplate.getForObject(url, DrinkDto.class);
        return apiResponse;
    }
}
