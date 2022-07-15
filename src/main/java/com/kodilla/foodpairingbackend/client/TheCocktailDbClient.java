package com.kodilla.foodpairingbackend.client;

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

    public DrinkDto getRandomDrink() {
        URI url = UriComponentsBuilder
                .fromHttpUrl("https://www.thecocktaildb.com/api/json/v1/1/random.php")
                .build()
                .encode()
                .toUri();

        DrinkDto apiResponse = restTemplate.getForObject(url, DrinkDto.class);
        return apiResponse;
    }
}
