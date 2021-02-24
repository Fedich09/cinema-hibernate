package com.dev.operaapp.service;

import com.dev.operaapp.model.PerformanceSession;
import com.dev.operaapp.model.ShoppingCart;
import com.dev.operaapp.model.User;

public interface ShoppingCartService {
    void addSession(PerformanceSession performanceSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
