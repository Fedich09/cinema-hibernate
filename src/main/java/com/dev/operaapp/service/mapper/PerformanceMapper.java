package com.dev.operaapp.service.mapper;

import com.dev.operaapp.model.Performance;
import com.dev.operaapp.model.dto.performance.PerformanceRequestDto;
import com.dev.operaapp.model.dto.performance.PerformanceResponseDto;
import com.dev.operaapp.service.mapper.genericmapper.GenericMapperRequest;
import com.dev.operaapp.service.mapper.genericmapper.GenericMapperResponse;

public interface PerformanceMapper extends GenericMapperResponse<PerformanceResponseDto,
        Performance>, GenericMapperRequest<Performance, PerformanceRequestDto> {
}
