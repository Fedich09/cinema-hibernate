package com.dev.cinema.controller;

import com.dev.cinema.model.dto.order.OrderResponseDto;
import com.dev.cinema.service.OrderService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import com.dev.cinema.service.mapper.OrderMapper;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public void completeOrder(Authentication auth) {
        Object principal = auth.getPrincipal();
        UserDetails details = (UserDetails) principal;
        orderService.completeOrder(cartService
                .getByUser(userService.findByEmail(details.getUsername()).orElseThrow(() ->
                        new NoSuchElementException("Can't get by email "))));
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistoryForUser(Authentication auth) {
        Object principal = auth.getPrincipal();
        UserDetails details = (UserDetails) principal;
        return orderService.getOrdersHistory(userService.findByEmail(details.getUsername())
                .get())
                .stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }
}
