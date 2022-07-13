package com.kodilla.foodpairingbackend.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "RATINGS")
public class Rating {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name  = "ID")
    private Long id;

    @NotNull
    @Column(name = "RATING")
    private int rating;

    @NotNull
    @Column(name = "CREATED")
    private Date created;

    public Rating(int rating, Date created) {
        this.rating = rating;
        this.created = created;
    }
}
