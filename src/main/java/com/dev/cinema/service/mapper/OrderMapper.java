package com.dev.cinema.service.mapper;

import com.dev.cinema.model.Order;
import com.dev.cinema.model.dto.order.OrderResponseDto;
import com.dev.cinema.service.mapper.genericmapper.GenericMapperResponse;

public interface OrderMapper extends GenericMapperResponse<OrderResponseDto, Order> {
}
