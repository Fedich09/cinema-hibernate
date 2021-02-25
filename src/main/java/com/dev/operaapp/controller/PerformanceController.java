package com.dev.operaapp.controller;

import com.dev.operaapp.model.dto.performance.PerformanceRequestDto;
import com.dev.operaapp.model.dto.performance.PerformanceResponseDto;
import com.dev.operaapp.service.PerformanceService;
import com.dev.operaapp.service.mapper.impl.PerformanceMapperImpl;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performances")
public class PerformanceController {
    private final PerformanceService performanceService;
    private final PerformanceMapperImpl performanceMapper;

    public PerformanceController(PerformanceService performanceService,
                                 PerformanceMapperImpl performanceMapper) {
        this.performanceService = performanceService;
        this.performanceMapper = performanceMapper;
    }

    @PostMapping
    public void create(@RequestBody @Valid PerformanceRequestDto requestDto) {
        performanceService.add(performanceMapper.toEntity(requestDto));
    }

    @RequestMapping
    public List<PerformanceResponseDto> getAll() {
        return performanceService.getAll().stream()
                .map(performanceMapper::toDto)
                .collect(Collectors.toList());
    }
}
