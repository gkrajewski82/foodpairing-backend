package com.kodilla.foodpairingbackend.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TheCocktailDbResultDto {

    @JsonProperty("drinks")
    private List<TheCocktailDbDrinkDto> resultList;

}
