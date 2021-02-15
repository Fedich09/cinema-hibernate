package com.dev.cinema.service.mapper.impl;

import com.dev.cinema.model.User;
import com.dev.cinema.model.dto.authentication.AuthenticationRequestDto;
import com.dev.cinema.service.mapper.AuthenticationMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationMapperImpl implements AuthenticationMapper {
    @Override
    public User toEntity(AuthenticationRequestDto requestDto) {
        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());
        return user;
    }
}
