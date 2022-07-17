package com.kodilla.foodpairingbackend.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "DISHES")
public class Dish {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "EXTERNAL_SYSTEM_ID")
    private Long externalSystemId;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @Column(name = "READY_IN_MINUTES")
    private int readyInMinutes;

    @Column(name = "SERVINGS")
    private int servings;

    @NotNull
    @Column(name = "RECIPE_URL")
    private String recipeUrl;

    @OneToMany(
            targetEntity = Composition.class,
            mappedBy = "dish",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Composition> composition;
}
