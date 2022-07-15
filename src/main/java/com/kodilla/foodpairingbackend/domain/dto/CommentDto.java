package com.kodilla.foodpairingbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CommentDto {

    private Long id;
    private String description;
    private Date created;
    private CompositionDto foodComposition;
    private List<RatingDto> ratingList;
}
