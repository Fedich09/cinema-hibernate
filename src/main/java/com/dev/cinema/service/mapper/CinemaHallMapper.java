package com.dev.cinema.service.mapper;

import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.model.dto.cinemahall.CinemaHallRequestDto;
import com.dev.cinema.model.dto.cinemahall.CinemaHallResponseDto;
import com.dev.cinema.service.mapper.genericmapper.GenericMapperRequest;
import com.dev.cinema.service.mapper.genericmapper.GenericMapperResponse;

public interface CinemaHallMapper extends GenericMapperResponse<CinemaHallResponseDto, CinemaHall>,
        GenericMapperRequest<CinemaHall, CinemaHallRequestDto> {
}
