package com.dev.cinema.controller;

import com.dev.cinema.model.dto.performance.PerformanceRequestDto;
import com.dev.cinema.model.dto.performance.PerformanceResponseDto;
import com.dev.cinema.service.PerformanceService;
import com.dev.cinema.service.mapper.impl.PerformanceMapperImpl;
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
    private final PerformanceMapperImpl movieMapperImpl;

    public PerformanceController(PerformanceService performanceService,
                                 PerformanceMapperImpl movieMapperImpl) {
        this.performanceService = performanceService;
        this.movieMapperImpl = movieMapperImpl;
    }

    @PostMapping
    public void create(@RequestBody @Valid PerformanceRequestDto requestDto) {
        performanceService.add(movieMapperImpl.toEntity(requestDto));
    }

    @RequestMapping
    public List<PerformanceResponseDto> getAll() {
        return performanceService.getAll().stream()
                .map(movieMapperImpl::toDto)
                .collect(Collectors.toList());
    }
}
