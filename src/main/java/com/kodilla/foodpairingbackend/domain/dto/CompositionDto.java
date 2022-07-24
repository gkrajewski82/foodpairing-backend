package com.kodilla.foodpairingbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CompositionDto {

    private Long id;
    private Long dishId;
    private Long drinkId;
    private Date created;
    private List<CommentDto> commentList;
}
