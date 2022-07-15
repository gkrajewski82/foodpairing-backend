package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.UserDto;
import com.kodilla.foodpairingbackend.domain.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    private FoodCompositionMapper foodCompositionMapper;

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getStatus(),
                userDto.getUserKey(),
                foodCompositionMapper.napToFoodCompositionList(userDto.getFoodCompositionList())
        );
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getStatus(),
                user.getUserKey(),
                foodCompositionMapper.napToFoodCompositionDtoList(user.getFoodCompositionList())
        );
    }
}
