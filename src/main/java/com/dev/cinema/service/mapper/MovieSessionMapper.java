package com.dev.cinema.service.mapper;

import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.dto.MovieSessionRequestDto;
import com.dev.cinema.model.dto.MovieSessionResponseDto;

public interface MovieSessionMapper extends GenericMapper<MovieSessionResponseDto,
        MovieSessionRequestDto, MovieSession> {
}
