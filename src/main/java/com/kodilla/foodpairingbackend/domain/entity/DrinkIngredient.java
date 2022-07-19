package com.kodilla.foodpairingbackend.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "DRINK_INGREDIENTS")
public class DrinkIngredient {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MEASURE")
    private String measure;

    @ManyToOne
    @JoinColumn(name = "DRINK_ID")
    private Drink drink;

    public DrinkIngredient(String name, String measure, Drink drink) {
        this.name = name;
        this.measure = measure;
        this.drink = drink;
    }
}
