package com.dev.cinema.service.mapper.impl;

import com.dev.cinema.model.Performance;
import com.dev.cinema.model.dto.performance.PerformanceRequestDto;
import com.dev.cinema.model.dto.performance.PerformanceResponseDto;
import com.dev.cinema.service.mapper.PerformanceMapper;
import org.springframework.stereotype.Component;

@Component
public class PerformanceMapperImpl implements PerformanceMapper {
    @Override
    public PerformanceResponseDto toDto(Performance performance) {
        PerformanceResponseDto dto = new PerformanceResponseDto();
        dto.setDescription(performance.getDescription());
        dto.setId(performance.getId());
        dto.setTitle(performance.getTitle());
        return dto;
    }

    @Override
    public Performance toEntity(PerformanceRequestDto requestDto) {
        Performance performance = new Performance();
        performance.setTitle(requestDto.getTitle());
        performance.setDescription(requestDto.getDescription());
        return performance;
    }
}
