package com.dev.cinema.controller;

import com.dev.cinema.model.dto.user.UserResponseDto;
import com.dev.cinema.service.UserService;
import com.dev.cinema.service.mapper.UserMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/by-email")
    public UserResponseDto getByEmail(Authentication auth) {
        Object principal = auth.getPrincipal();
        UserDetails details = (UserDetails) principal;
        return userMapper.toDto(userService.findByEmail(details.getUsername()));
    }
}
