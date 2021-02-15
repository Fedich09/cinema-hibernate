package com.dev.cinema.controller;

import com.dev.cinema.model.dto.user.UserResponseDto;
import com.dev.cinema.service.UserService;
import com.dev.cinema.service.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @RequestMapping("/by-email")
    public UserResponseDto getByEmail(@RequestParam String email) {
        return userMapper.toDto(userService.findByEmail(email).orElseThrow(() ->
                new RuntimeException("Can't find by email " + email)));
    }
}
