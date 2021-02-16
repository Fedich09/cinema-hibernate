package com.dev.cinema.controller;

import com.dev.cinema.model.dto.movie.MovieRequestDto;
import com.dev.cinema.model.dto.movie.MovieResponseDto;
import com.dev.cinema.service.MovieService;
import com.dev.cinema.service.mapper.impl.MovieMapperImpl;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapperImpl movieMapperImpl;

    public MovieController(MovieService movieService, MovieMapperImpl movieMapperImpl) {
        this.movieService = movieService;
        this.movieMapperImpl = movieMapperImpl;
    }

    @PostMapping
    public void create(@RequestBody MovieRequestDto requestDto) {
        movieService.add(movieMapperImpl.toEntity(requestDto));
    }

    @RequestMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(movieMapperImpl::toDto)
                .collect(Collectors.toList());
    }
}
