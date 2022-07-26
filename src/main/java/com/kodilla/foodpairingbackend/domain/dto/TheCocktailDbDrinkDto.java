package com.kodilla.foodpairingbackend.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TheCocktailDbDrinkDto {

    @JsonProperty("idDrink")
    private String externalSystemId;

    @JsonProperty("strDrink")
    private String name;

    @JsonProperty("strAlcoholic")
    private String alcoholic;

    @JsonProperty("strGlass")
    private String glass;

    @JsonProperty("strIngredient1")
    private String ingredient1;

    @JsonProperty("strIngredient2")
    private String ingredient2;

    @JsonProperty("strIngredient3")
    private String ingredient3;

    @JsonProperty("strIngredient4")
    private String ingredient4;

    @JsonProperty("strIngredient5")
    private String ingredient5;

    @JsonProperty("strIngredient6")
    private String ingredient6;

    @JsonProperty("strIngredient7")
    private String ingredient7;

    @JsonProperty("strIngredient8")
    private String ingredient8;

    @JsonProperty("strIngredient9")
    private String ingredient9;

    @JsonProperty("strIngredient10")
    private String ingredient10;

    @JsonProperty("strIngredient11")
    private String ingredient11;

    @JsonProperty("strIngredient12")
    private String ingredient12;

    @JsonProperty("strIngredient13")
    private String ingredient13;

    @JsonProperty("strIngredient14")
    private String ingredient14;

    @JsonProperty("strIngredient15")
    private String ingredient15;

    @JsonProperty("strMeasure1")
    private String measure1;

    @JsonProperty("strMeasure2")
    private String measure2;

    @JsonProperty("strMeasure3")
    private String measure3;

    @JsonProperty("strMeasure4")
    private String measure4;

    @JsonProperty("strMeasure5")
    private String measure5;

    @JsonProperty("strMeasure6")
    private String measure6;

    @JsonProperty("strMeasure7")
    private String measure7;

    @JsonProperty("strMeasure8")
    private String measure8;

    @JsonProperty("strMeasure9")
    private String measure9;

    @JsonProperty("strMeasure10")
    private String measure10;

    @JsonProperty("strMeasure11")
    private String measure11;

    @JsonProperty("strMeasure12")
    private String measure12;

    @JsonProperty("strMeasure13")
    private String measure13;

    @JsonProperty("strMeasure14")
    private String measure14;

    @JsonProperty("strMeasure15")
    private String measure15;

    public List<DrinkIngredientDto> createDrinkIngredientList() {
        List<DrinkIngredientDto> drinkIngredientList = new ArrayList<>();
        drinkIngredientList.add(new DrinkIngredientDto(null, getIngredient1(), getMeasure1(), null));
        drinkIngredientList.add(new DrinkIngredientDto(null, getIngredient2(), getMeasure2(), null));
        drinkIngredientList.add(new DrinkIngredientDto(null, getIngredient3(), getMeasure3(), null));
        drinkIngredientList.add(new DrinkIngredientDto(null, getIngredient4(), getMeasure4(), null));
        drinkIngredientList.add(new DrinkIngredientDto(null, getIngredient5(), getMeasure5(), null));
        drinkIngredientList.add(new DrinkIngredientDto(null, getIngredient6(), getMeasure6(), null));
        drinkIngredientList.add(new DrinkIngredientDto(null, getIngredient7(), getMeasure7(), null));
        drinkIngredientList.add(new DrinkIngredientDto(null, getIngredient8(), getMeasure8(), null));
        drinkIngredientList.add(new DrinkIngredientDto(null, getIngredient9(), getMeasure9(), null));
        drinkIngredientList.add(new DrinkIngredientDto(null, getIngredient10(), getMeasure10(), null));
        drinkIngredientList.add(new DrinkIngredientDto(null, getIngredient11(), getMeasure11(), null));
        drinkIngredientList.add(new DrinkIngredientDto(null, getIngredient12(), getMeasure12(), null));
        drinkIngredientList.add(new DrinkIngredientDto(null, getIngredient13(), getMeasure13(), null));
        drinkIngredientList.add(new DrinkIngredientDto(null, getIngredient14(), getMeasure14(), null));
        drinkIngredientList.add(new DrinkIngredientDto(null, getIngredient15(), getMeasure15(), null));
        return drinkIngredientList;
    }
}