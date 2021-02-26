package com.dev.operaapp.service.mapper;

import com.dev.operaapp.model.User;
import com.dev.operaapp.model.dto.user.UserResponseDto;
import com.dev.operaapp.service.mapper.genericmapper.GenericMapperResponse;

public interface UserMapper extends GenericMapperResponse<UserResponseDto, User> {
}
