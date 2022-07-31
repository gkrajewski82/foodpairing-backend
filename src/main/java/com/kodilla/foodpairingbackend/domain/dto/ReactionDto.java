package com.kodilla.foodpairingbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Getter
public class ReactionDto {

    private Long id;
    private String description;
    private Date created;
    private Long commentId;
}
