package com.dev.cinema.service.mapper;

import com.dev.cinema.model.ShoppingCart;
import com.dev.cinema.model.dto.shoppingcart.ShoppingCartResponseDto;
import com.dev.cinema.service.mapper.genericmapper.GenericMapperResponse;

public interface ShoppingCartMapper extends GenericMapperResponse<ShoppingCartResponseDto,
        ShoppingCart> {
}
