package com.dev.operaapp.service.mapper.impl;

import com.dev.operaapp.model.Stage;
import com.dev.operaapp.model.dto.stage.StageRequestDto;
import com.dev.operaapp.model.dto.stage.StageResponseDto;
import com.dev.operaapp.service.mapper.StageMapper;
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
