package com.dev.cinema.service.mapper.impl;

import com.dev.cinema.model.User;
import com.dev.cinema.model.dto.user.UserResponseDto;
import com.dev.cinema.service.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponseDto toDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        return responseDto;
    }
}
