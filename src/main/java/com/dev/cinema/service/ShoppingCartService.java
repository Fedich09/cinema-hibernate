package com.dev.cinema.service;

import com.dev.cinema.model.PerformanceSession;
import com.dev.cinema.model.ShoppingCart;
import com.dev.cinema.model.User;

public interface ShoppingCartService {
    void addSession(PerformanceSession performanceSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
