package com.dev.cinema.service.mapper;

import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.dto.moviesession.MovieSessionRequestDto;
import com.dev.cinema.model.dto.moviesession.MovieSessionResponseDto;
import com.dev.cinema.service.mapper.genericmapper.GenericMapperRequest;
import com.dev.cinema.service.mapper.genericmapper.GenericMapperResponse;

public interface MovieSessionMapper extends GenericMapperResponse<MovieSessionResponseDto,
        MovieSession>, GenericMapperRequest<MovieSession, MovieSessionRequestDto> {
}
