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
@Entity(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "USERNAME")
    private String username;

    @NotNull
    @Column(name = "STATUS")
    private int status;

    @NotNull
    @Column(name = "USER_KEY")
    private String userKey;

    @OneToMany(
            targetEntity = FoodComposition.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<FoodComposition> foodCompositionList;

    public User(String username, int status, String userKey) {
        this.username = username;
        this.status = status;
        this.userKey = userKey;
    }
}
