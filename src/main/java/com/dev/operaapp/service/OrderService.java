package com.dev.operaapp.service;

import com.dev.operaapp.model.Order;
import com.dev.operaapp.model.ShoppingCart;
import com.dev.operaapp.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
