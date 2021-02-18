package com.dev.cinema.controller;

import com.dev.cinema.model.dto.cinemahall.CinemaHallRequestDto;
import com.dev.cinema.model.dto.cinemahall.CinemaHallResponseDto;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.mapper.impl.CinemaHallMapperImpl;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallMapperImpl cinemaHallMapperImpl;
    private final CinemaHallService cinemaHallService;

    public CinemaHallController(CinemaHallMapperImpl cinemaHallMapperImpl,
                                CinemaHallService cinemaHallService) {
        this.cinemaHallMapperImpl = cinemaHallMapperImpl;
        this.cinemaHallService = cinemaHallService;
    }

    @PostMapping
    public void create(@RequestBody @Valid CinemaHallRequestDto requestDto) {
        cinemaHallService.add(cinemaHallMapperImpl.toEntity(requestDto));
    }

    @RequestMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallMapperImpl::toDto)
                .collect(Collectors.toList());
    }
}
