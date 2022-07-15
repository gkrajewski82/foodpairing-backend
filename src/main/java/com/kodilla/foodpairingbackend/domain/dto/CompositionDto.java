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
    private UserDto user;
    private DishDto dish;
    private DrinkDto drink;
    private Date created;
    private List<CommentDto> commentList;
}
