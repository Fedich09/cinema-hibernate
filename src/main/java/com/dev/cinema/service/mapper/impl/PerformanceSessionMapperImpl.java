package com.dev.cinema.service.mapper.impl;

import com.dev.cinema.model.PerformanceSession;
import com.dev.cinema.model.dto.performancesession.PerformanceSessionRequestDto;
import com.dev.cinema.model.dto.performancesession.PerformanceSessionResponseDto;
import com.dev.cinema.service.PerformanceService;
import com.dev.cinema.service.StageService;
import com.dev.cinema.service.mapper.PerformanceSessionMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class PerformanceSessionMapperImpl implements PerformanceSessionMapper {
    private PerformanceService performanceService;
    private StageService stageService;

    public PerformanceSessionMapperImpl(PerformanceService performanceService,
                                        StageService stageService) {
        this.performanceService = performanceService;
        this.stageService = stageService;
    }

    @Override
    public PerformanceSessionResponseDto toDto(PerformanceSession session) {
        PerformanceSessionResponseDto responseDto = new PerformanceSessionResponseDto();
        responseDto.setId(session.getId());
        responseDto.setStageDescription(session.getStage().getDescription());
        responseDto.setPerformanceDescription(session.getPerformance().getDescription());
        responseDto.setPerformanceTitle(session.getPerformance().getTitle());
        responseDto.setStageId(session.getStage().getId());
        responseDto.setShowTime(session.getShowTime().toString());
        return responseDto;
    }

    @Override
    public PerformanceSession toEntity(PerformanceSessionRequestDto responseDto) {
        PerformanceSession performanceSession = new PerformanceSession();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        performanceSession.setPerformance(performanceService.get(responseDto.getPerformanceId()));
        performanceSession.setStage(stageService.get(responseDto.getStageId()));
        performanceSession.setShowTime(LocalDateTime.parse(responseDto.getShowTime(), formatter));
        return performanceSession;
    }
}
