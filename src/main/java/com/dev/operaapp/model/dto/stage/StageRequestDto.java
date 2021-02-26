package com.dev.operaapp.model.dto.stage;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StageRequestDto {
    @NotNull(message = "The capacity couldn't be null")
    @Min(value = 1, message = "The capacity should be greater or equal 1")
    private Integer capacity;
    @Size(min = 4, message = "The description should be longer then 4")
    private String description;

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
