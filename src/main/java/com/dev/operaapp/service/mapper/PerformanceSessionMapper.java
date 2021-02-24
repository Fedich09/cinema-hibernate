package com.dev.operaapp.service.mapper;

import com.dev.operaapp.model.PerformanceSession;
import com.dev.operaapp.model.dto.performancesession.PerformanceSessionRequestDto;
import com.dev.operaapp.model.dto.performancesession.PerformanceSessionResponseDto;
import com.dev.operaapp.service.mapper.genericmapper.GenericMapperRequest;
import com.dev.operaapp.service.mapper.genericmapper.GenericMapperResponse;

public interface PerformanceSessionMapper extends GenericMapperResponse
        <PerformanceSessionResponseDto, PerformanceSession>,
        GenericMapperRequest<PerformanceSession, PerformanceSessionRequestDto> {
}
