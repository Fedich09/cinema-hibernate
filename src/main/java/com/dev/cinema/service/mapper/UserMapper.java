package com.dev.cinema.service.mapper;

import com.dev.cinema.model.User;
import com.dev.cinema.model.dto.user.UserResponseDto;
import com.dev.cinema.service.mapper.genericmapper.GenericMapperResponse;

public interface UserMapper extends GenericMapperResponse<UserResponseDto, User> {
}
