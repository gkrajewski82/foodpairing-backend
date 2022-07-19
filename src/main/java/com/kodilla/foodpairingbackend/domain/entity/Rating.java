package com.kodilla.foodpairingbackend.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @Column(name = "VALUE")
    private int value;

    @NotNull
    @Column(name = "CREATED")
    private Date created;

    @ManyToOne
    @JoinColumn(name = "COMMENT_ID")
    private Comment comment;

    public Rating(int value, Date created, Comment comment) {
        this.value = value;
        this.created = created;
        this.comment = comment;
    }
}
