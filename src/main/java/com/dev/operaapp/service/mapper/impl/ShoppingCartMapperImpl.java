package com.dev.operaapp.service.mapper.impl;

import com.dev.operaapp.model.ShoppingCart;
import com.dev.operaapp.model.Ticket;
import com.dev.operaapp.model.dto.shoppingcart.ShoppingCartResponseDto;
import com.dev.operaapp.service.mapper.ShoppingCartMapper;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapperImpl implements ShoppingCartMapper {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setId(shoppingCart.getId());
        responseDto.setTicketIds(shoppingCart.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
