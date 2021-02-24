package com.dev.cinema.service.mapper.impl;

import com.dev.cinema.model.Stage;
import com.dev.cinema.model.dto.stage.StageRequestDto;
import com.dev.cinema.model.dto.stage.StageResponseDto;
import com.dev.cinema.service.mapper.StageMapper;
import org.springframework.stereotype.Component;

@Component
public class StageMapperImpl implements StageMapper {

    @Override
    public StageResponseDto toDto(Stage stage) {
        StageResponseDto stageResponseDto = new StageResponseDto();
        stageResponseDto.setCapacity(stage.getCapacity());
        stageResponseDto.setDescription(stage.getDescription());
        stageResponseDto.setId(stage.getId());
        return stageResponseDto;
    }

    @Override
    public Stage toEntity(StageRequestDto requestDto) {
        Stage stage = new Stage();
        stage.setCapacity(requestDto.getCapacity());
        stage.setDescription(requestDto.getDescription());
        return stage;
    }
}
