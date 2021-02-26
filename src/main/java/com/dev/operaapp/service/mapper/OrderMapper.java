package com.dev.operaapp.service.mapper;

import com.dev.operaapp.model.Order;
import com.dev.operaapp.model.dto.order.OrderResponseDto;
import com.dev.operaapp.service.mapper.genericmapper.GenericMapperResponse;

public interface OrderMapper extends GenericMapperResponse<OrderResponseDto, Order> {
}
