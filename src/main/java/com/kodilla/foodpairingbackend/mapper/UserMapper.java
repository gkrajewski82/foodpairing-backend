package com.kodilla.foodpairingbackend.mapper;

import com.kodilla.foodpairingbackend.domain.dto.UserDto;
import com.kodilla.foodpairingbackend.domain.entity.User;
import com.kodilla.foodpairingbackend.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserMapper {

    private final CompositionMapper compositionMapper;

    public User mapToUser(final UserDto userDto) throws UserNotFoundException, DrinkNotFoundException,
            DishNotFoundException, CompositionNotFoundException, CommentNotFoundException {
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getStatus(),
                userDto.getUserKey(),
                compositionMapper.mapToCompositionList(userDto.getCompositionList())
        );
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getStatus(),
                user.getUserKey(),
                compositionMapper.mapToCompositionDtoList(user.getCompositionList())
        );
    }

    public List<User> mapToUserList(final List<UserDto> userDtoList) throws UserNotFoundException,DrinkNotFoundException,
            DishNotFoundException, CompositionNotFoundException, CommentNotFoundException {
        List<User> userList = new ArrayList<>();
        for (UserDto userDto : userDtoList) {
            User user = mapToUser(userDto);
            userList.add(user);
        }
        return userList;
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
