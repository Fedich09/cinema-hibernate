package com.dev.operaapp.controller;

import com.dev.operaapp.model.PerformanceSession;
import com.dev.operaapp.model.dto.performancesession.PerformanceSessionRequestDto;
import com.dev.operaapp.model.dto.performancesession.PerformanceSessionResponseDto;
import com.dev.operaapp.service.PerformanceSessionService;
import com.dev.operaapp.service.mapper.impl.PerformanceSessionMapperImpl;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performance-sessions")
public class PerformanceSessionController {
    private final PerformanceSessionService performanceSessionService;
    private final PerformanceSessionMapperImpl sessionMapper;

    public PerformanceSessionController(PerformanceSessionService performanceSessionService,
                                        PerformanceSessionMapperImpl sessionMapper) {
        this.performanceSessionService = performanceSessionService;
        this.sessionMapper = sessionMapper;
    }

    @PostMapping
    public void create(
            @RequestBody @Valid PerformanceSessionRequestDto performanceSessionRequestDto) {
        performanceSessionService.add(sessionMapper.toEntity(performanceSessionRequestDto));
    }

    @RequestMapping("/available")
    public List<PerformanceSessionResponseDto> getAvailableSession(@RequestParam(value =
            "performanceId") Long id, @RequestParam(value = "date") @DateTimeFormat(pattern =
            "dd.MM.yyyy") LocalDate showTime) {
        return performanceSessionService.findAvailableSessions(id,
                showTime).stream()
                .map(sessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void update(@RequestBody PerformanceSessionRequestDto performanceSessionRequestDto,
                       @PathVariable Long id) {
        PerformanceSession performanceSession = sessionMapper
                .toEntity(performanceSessionRequestDto);
        performanceSession.setId(id);
        performanceSessionService.update(performanceSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        performanceSessionService.delete(id);
    }
}
