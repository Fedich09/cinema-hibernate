package com.dev.operaapp.controller;

import com.dev.operaapp.model.dto.stage.StageRequestDto;
import com.dev.operaapp.model.dto.stage.StageResponseDto;
import com.dev.operaapp.service.StageService;
import com.dev.operaapp.service.mapper.impl.StageMapperImpl;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stages")
public class StageController {
    private final StageMapperImpl cinemaHallMapperImpl;
    private final StageService stageService;

    public StageController(StageMapperImpl cinemaHallMapperImpl,
                           StageService stageService) {
        this.cinemaHallMapperImpl = cinemaHallMapperImpl;
        this.stageService = stageService;
    }

    @PostMapping
    public void create(@RequestBody @Valid StageRequestDto requestDto) {
        stageService.add(cinemaHallMapperImpl.toEntity(requestDto));
    }

    @RequestMapping
    public List<StageResponseDto> getAll() {
        return stageService.getAll().stream()
                .map(cinemaHallMapperImpl::toDto)
                .collect(Collectors.toList());
    }
}
