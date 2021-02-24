package com.dev.cinema.model.dto.performancesession;

public class PerformanceSessionResponseDto {
    private Long id;
    private String performanceTitle;
    private String PerformanceDescription;
    private Long stageId;
    private String stageDescription;
    private String showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerformanceTitle() {
        return performanceTitle;
    }

    public void setPerformanceTitle(String performanceTitle) {
        this.performanceTitle = performanceTitle;
    }

    public String getPerformanceDescription() {
        return PerformanceDescription;
    }

    public void setPerformanceDescription(String performanceDescription) {
        this.PerformanceDescription = performanceDescription;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public String getStageDescription() {
        return stageDescription;
    }

    public void setStageDescription(String stageDescription) {
        this.stageDescription = stageDescription;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
