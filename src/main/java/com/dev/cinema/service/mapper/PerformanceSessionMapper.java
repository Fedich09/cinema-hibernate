package com.dev.cinema.service.mapper;

import com.dev.cinema.model.PerformanceSession;
import com.dev.cinema.model.dto.performancesession.PerformanceSessionRequestDto;
import com.dev.cinema.model.dto.performancesession.PerformanceSessionResponseDto;
import com.dev.cinema.service.mapper.genericmapper.GenericMapperRequest;
import com.dev.cinema.service.mapper.genericmapper.GenericMapperResponse;

public interface PerformanceSessionMapper extends GenericMapperResponse<PerformanceSessionResponseDto,
        PerformanceSession>, GenericMapperRequest<PerformanceSession, PerformanceSessionRequestDto> {
}
