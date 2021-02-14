package com.dev.cinema.service.mapper;

import com.dev.cinema.model.Movie;
import com.dev.cinema.model.dto.MovieRequestDto;
import com.dev.cinema.model.dto.MovieResponseDto;

public interface MovieMapper extends GenericMapper<MovieResponseDto,
        MovieRequestDto, Movie> {
}
