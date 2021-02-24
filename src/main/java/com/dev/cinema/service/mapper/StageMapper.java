package com.dev.cinema.service.mapper;

import com.dev.cinema.model.Stage;
import com.dev.cinema.model.dto.stage.StageRequestDto;
import com.dev.cinema.model.dto.stage.StageResponseDto;
import com.dev.cinema.service.mapper.genericmapper.GenericMapperRequest;
import com.dev.cinema.service.mapper.genericmapper.GenericMapperResponse;

public interface StageMapper extends GenericMapperResponse<StageResponseDto, Stage>,
        GenericMapperRequest<Stage, StageRequestDto> {
}
