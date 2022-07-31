package com.kodilla.foodpairingbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@Getter
public class CompositionDto {

    private Long id;
    private Long dishId;
    private Long drinkId;
    private Date created;
    private List<CommentDto> commentList;
}
