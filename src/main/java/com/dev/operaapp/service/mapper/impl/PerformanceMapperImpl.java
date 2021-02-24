package com.dev.operaapp.service.mapper.impl;

import com.dev.operaapp.model.Performance;
import com.dev.operaapp.model.dto.performance.PerformanceRequestDto;
import com.dev.operaapp.model.dto.performance.PerformanceResponseDto;
import com.dev.operaapp.service.mapper.PerformanceMapper;
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
