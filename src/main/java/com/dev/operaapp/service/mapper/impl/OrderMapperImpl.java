package com.dev.operaapp.service.mapper.impl;

import com.dev.operaapp.model.Order;
import com.dev.operaapp.model.Ticket;
import com.dev.operaapp.model.dto.order.OrderResponseDto;
import com.dev.operaapp.service.mapper.OrderMapper;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements OrderMapper {
    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setUserId(order.getUser().getId());
        orderResponseDto.setOrderDateTime(order.getOrderDate().toString());
        orderResponseDto.setTicketIds(order.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return orderResponseDto;
    }
}
