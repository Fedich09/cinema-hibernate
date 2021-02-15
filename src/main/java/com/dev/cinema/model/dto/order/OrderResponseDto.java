package com.dev.cinema.model.dto.order;

import java.time.LocalDate;
import java.util.List;

public class OrderResponseDto {
    private Long id;
    private List<Long> ticketsId;
    private LocalDate orderDateTime;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
    }

    public LocalDate getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDate orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
