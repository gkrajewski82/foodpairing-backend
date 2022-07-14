package com.kodilla.foodpairingbackend.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "DRINKS")
public class Drink {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "EXTERNAL_SYSTEM_ID")
    private Long externalSystemId;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "ALCOHOLIC")
    private boolean alcoholic;

    @Column(name = "GLASS")
    private String glass;

    @OneToMany(
            targetEntity = DrinkIngredient.class,
            mappedBy = "drink",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<DrinkIngredient> DrinkIngredientList;

    public Drink(Long externalSystemId, String name, boolean alcoholic, String glass) {
        this.externalSystemId = externalSystemId;
        this.name = name;
        this.alcoholic = alcoholic;
        this.glass = glass;
    }
}
