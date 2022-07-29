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
@Entity(name = "REACTIONS")
public class Reaction {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name  = "ID")
    private Long id;

    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "CREATED")
    private Date created;

    @ManyToOne
    @JoinColumn(name = "COMMENT_ID")
    private Comment comment;
}