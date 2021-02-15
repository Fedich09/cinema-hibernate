package com.dev.cinema.controller;

import com.dev.cinema.model.dto.authentication.AuthenticationRequestDto;
import com.dev.cinema.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public void register(@RequestBody AuthenticationRequestDto requestDto) {
        authenticationService.register(requestDto.getEmail(), requestDto.getPassword());
    }
}
