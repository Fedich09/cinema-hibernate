package com.dev.cinema.service.mapper;

import com.dev.cinema.model.User;
import com.dev.cinema.model.dto.authentication.AuthenticationRequestDto;
import com.dev.cinema.service.mapper.genericmapper.GenericMapperRequest;

public interface AuthenticationMapper extends GenericMapperRequest<User,
        AuthenticationRequestDto> {
}
