package com.kodilla.foodpairingbackend.domain.entities;

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
@Entity(name = "COMMENTS")
public class Comment {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "CREATED")
    private Date created;

    @ManyToOne
    @JoinColumn(name = "COMPOSITION_ID")
    private Composition composition;

    @OneToMany(
            targetEntity = Rating.class,
            mappedBy = "comment",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Rating> ratingList;

    public Comment(String description, Date created) {
        this.description = description;
        this.created = created;
    }
}
