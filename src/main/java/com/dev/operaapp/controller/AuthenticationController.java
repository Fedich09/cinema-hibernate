package com.dev.operaapp.controller;

import com.dev.operaapp.model.dto.authentication.AuthenticationRequestDto;
import com.dev.operaapp.security.AuthenticationService;
import javax.validation.Valid;
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
    public void register(@RequestBody @Valid AuthenticationRequestDto requestDto) {
        authenticationService.register(requestDto.getEmail(), requestDto.getPassword());
    }
}
