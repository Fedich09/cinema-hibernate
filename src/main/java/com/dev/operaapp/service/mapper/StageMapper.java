package com.dev.operaapp.service.mapper;

import com.dev.operaapp.model.Stage;
import com.dev.operaapp.model.dto.stage.StageRequestDto;
import com.dev.operaapp.model.dto.stage.StageResponseDto;
import com.dev.operaapp.service.mapper.genericmapper.GenericMapperRequest;
import com.dev.operaapp.service.mapper.genericmapper.GenericMapperResponse;

public interface StageMapper extends GenericMapperResponse<StageResponseDto, Stage>,
        GenericMapperRequest<Stage, StageRequestDto> {
}
