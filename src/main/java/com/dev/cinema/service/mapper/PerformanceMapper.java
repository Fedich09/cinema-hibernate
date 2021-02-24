package com.dev.cinema.service.mapper;

import com.dev.cinema.model.Performance;
import com.dev.cinema.model.dto.performance.PerformanceRequestDto;
import com.dev.cinema.model.dto.performance.PerformanceResponseDto;
import com.dev.cinema.service.mapper.genericmapper.GenericMapperRequest;
import com.dev.cinema.service.mapper.genericmapper.GenericMapperResponse;

public interface PerformanceMapper extends GenericMapperResponse<PerformanceResponseDto, Performance>,
        GenericMapperRequest<Performance, PerformanceRequestDto> {
}
