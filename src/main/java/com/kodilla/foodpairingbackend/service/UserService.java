package com.kodilla.foodpairingbackend.service;

import com.kodilla.foodpairingbackend.domain.dto.UserDto;
import com.kodilla.foodpairingbackend.domain.entity.User;
import com.kodilla.foodpairingbackend.exception.UserNotFoundException;
import com.kodilla.foodpairingbackend.mapper.UserMapper;
import com.kodilla.foodpairingbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getUsers() {
        List<User> userList = userRepository.findAll();
        return userMapper.mapToUserDtoList(userList);
    }

    public UserDto getUser(final Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return userMapper.mapToUserDto(user);
    }

    public void deleteUser(final Long userId) {
        userRepository.deleteById(userId);
    }

    public UserDto saveUser(final UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.mapToUserDto(savedUser);
    }
}
