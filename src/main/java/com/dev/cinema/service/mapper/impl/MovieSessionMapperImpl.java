package com.dev.cinema.service.mapper.impl;

import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.dto.MovieSessionRequestDto;
import com.dev.cinema.model.dto.MovieSessionResponseDto;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import com.dev.cinema.service.mapper.MovieSessionMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapperImpl implements MovieSessionMapper {
    private MovieService movieService;
    private CinemaHallService cinemaHallService;

    public MovieSessionMapperImpl(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    @Override
    public MovieSessionResponseDto toDto(MovieSession session) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setId(session.getId());
        responseDto.setCinemaDescription(session.getCinemaHall().getDescription());
        responseDto.setMovieDescription(session.getMovie().getDescription());
        responseDto.setMovieTitle(session.getMovie().getTitle());
        responseDto.setCinemaId(session.getCinemaHall().getId());
        responseDto.setShowTime(session.getShowTime().toString());
        return responseDto;
    }

    @Override
    public MovieSession toEntity(MovieSessionRequestDto responseDto) {
        MovieSession movieSession = new MovieSession();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        movieSession.setMovie(movieService.get(responseDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(responseDto.getCinemaHallId()));
        movieSession.setShowTime(LocalDateTime.parse(responseDto.getShowTime(), formatter));
        return movieSession;
    }
}
