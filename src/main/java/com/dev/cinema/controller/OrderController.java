package com.dev.cinema.controller;

import com.dev.cinema.model.dto.order.OrderResponseDto;
import com.dev.cinema.service.OrderService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import com.dev.cinema.service.mapper.OrderMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderMapper orderMapper;
    private final OrderService orderService;
    private final UserService userService;
    private final ShoppingCartService cartService;

    public OrderController(OrderMapper orderMapper,
                           OrderService orderService,
                           UserService userService,
                           ShoppingCartService cartService) {
        this.orderMapper = orderMapper;
        this.orderService = orderService;
        this.userService = userService;
        this.cartService = cartService;
    }

    @PostMapping("/complete")
    public void completeOrder(@RequestParam Long userId) {
        orderService.completeOrder(cartService.getByUser(userService.get(userId)));
    }

    @RequestMapping
    public List<OrderResponseDto> getOrdersHistoryForUser(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }
}
