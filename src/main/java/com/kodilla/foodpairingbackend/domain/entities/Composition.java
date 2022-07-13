package com.kodilla.foodpairingbackend.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name ="COMPOSITIONS")
public class Composition {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "EXTERNAL_SYSTEM_DISH_ID")
    private Long externalSystemDishId;

    @NotNull
    @Column(name = "DISH_NAME")
    private String dishName;

    @Column(name = "READY_IN_MINUTES")
    private int readyInMinutes;

    @Column(name = "SERVINGS")
    private int servings;

    @NotNull
    @Column(name = "DISH_RECIPE_URL")
    private String dishRecipeUrl;

    public Composition(Long externalSystemDishId, String dishName, int readyInMinutes, int servings, String dishRecipeUrl) {
        this.externalSystemDishId = externalSystemDishId;
        this.dishName = dishName;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.dishRecipeUrl = dishRecipeUrl;
    }
}
