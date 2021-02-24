package com.dev.cinema.model.dto.performance;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PerformanceRequestDto {
    @NotNull(message = "The title couldn't be null")
    @Size(min = 6)
    private String title;
    @NotNull(message = "The description couldn't be null")
    @Size(min = 6)
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
