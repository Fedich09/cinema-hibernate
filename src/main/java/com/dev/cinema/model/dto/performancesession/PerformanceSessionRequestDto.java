package com.dev.cinema.model.dto.performancesession;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PerformanceSessionRequestDto {
    @NotNull(message = "The movieId couldn't be null")
    @Min(value = 1, message = "Length should be greater then 1")
    private Long movieId;
    @NotNull(message = "The cinemaHallId couldn't be null")
    @Min(value = 1, message = "Length should be greater then 1")
    private Long cinemaHallId;
    @Size(min = 10, message = "Length should be greater then 10")
    private String showTime;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
