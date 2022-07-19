package com.kodilla.foodpairingbackend.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DISH_ID")
    private Dish dish;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "DRINK_ID")
    private Drink drink;

    @NotNull
    @Column(name = "CREATED")
    private Date created;

    @OneToMany(
            targetEntity = Comment.class,
            mappedBy = "composition",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Comment> commentList;

    public Composition(User user, Dish dish, Drink drink, Date created) {
        this.user = user;
        this.dish = dish;
        this.drink = drink;
        this.created = created;
    }
}
