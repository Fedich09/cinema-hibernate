package com.dev.operaapp.model.dto.performancesession;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PerformanceSessionRequestDto {
    @NotNull(message = "The movieId couldn't be null")
    @Min(value = 1, message = "Length should be greater then 1")
    private Long performanceId;
    @NotNull(message = "The cinemaHallId couldn't be null")
    @Min(value = 1, message = "Length should be greater then 1")
    private Long stageId;
    @Size(min = 10, message = "Length should be greater then 10")
    private String showTime;

    public Long getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Long performanceId) {
        this.performanceId = performanceId;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
