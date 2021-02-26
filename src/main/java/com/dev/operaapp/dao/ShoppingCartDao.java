package com.dev.operaapp.dao;

import com.dev.operaapp.model.ShoppingCart;
import com.dev.operaapp.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
