package com.kodilla.foodpairingbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDto {

    private Long id;
    private String username;
    private int status;
    private String userKey;
    private List<CompositionDto> foodCompositionList;
}
