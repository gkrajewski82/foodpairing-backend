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
@Entity(name ="FOOD_COMPOSITIONS")
public class FoodComposition {

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "DRINK_ID")
    private Drink drink;

    @OneToMany(
            targetEntity = Comment.class,
            mappedBy = "foodComposition",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Comment> commentList;

    public FoodComposition(Long externalSystemDishId, String dishName, int readyInMinutes, int servings, String dishRecipeUrl) {
        this.externalSystemDishId = externalSystemDishId;
        this.dishName = dishName;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.dishRecipeUrl = dishRecipeUrl;
    }
}
