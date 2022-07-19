package com.kodilla.foodpairingbackend.controller;

import com.kodilla.foodpairingbackend.domain.dto.UserDto;
import com.kodilla.foodpairingbackend.domain.entity.User;
import com.kodilla.foodpairingbackend.exception.*;
import com.kodilla.foodpairingbackend.mapper.UserMapper;
import com.kodilla.foodpairingbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodpairing/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> userList = userService.getUsers();
        return ResponseEntity.ok(userMapper.mapToUserDtoList(userList));
    }

    @GetMapping(value = "{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) throws UserNotFoundException {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(userMapper.mapToUserDto(user));
    }

    @DeleteMapping(value = "{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) throws UserNotFoundException, DrinkNotFoundException, DishNotFoundException, CompositionNotFoundException, CommentNotFoundException {
        User user = userMapper.mapToUser(userDto);
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(userMapper.mapToUserDto(savedUser));
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) throws UserNotFoundException, DrinkNotFoundException, DishNotFoundException, CompositionNotFoundException, CommentNotFoundException {
        User user = userMapper.mapToUser(userDto);
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(userMapper.mapToUserDto(savedUser));
    }
}
