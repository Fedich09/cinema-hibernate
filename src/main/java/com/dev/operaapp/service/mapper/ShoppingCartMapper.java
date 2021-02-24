package com.dev.operaapp.service.mapper;

import com.dev.operaapp.model.ShoppingCart;
import com.dev.operaapp.model.dto.shoppingcart.ShoppingCartResponseDto;
import com.dev.operaapp.service.mapper.genericmapper.GenericMapperResponse;

public interface ShoppingCartMapper extends GenericMapperResponse<ShoppingCartResponseDto,
        ShoppingCart> {
}
