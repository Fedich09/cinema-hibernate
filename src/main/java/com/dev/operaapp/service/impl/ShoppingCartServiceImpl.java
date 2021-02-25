package com.dev.operaapp.service.impl;

import com.dev.operaapp.dao.ShoppingCartDao;
import com.dev.operaapp.dao.TicketDao;
import com.dev.operaapp.model.PerformanceSession;
import com.dev.operaapp.model.ShoppingCart;
import com.dev.operaapp.model.Ticket;
import com.dev.operaapp.model.User;
import com.dev.operaapp.service.ShoppingCartService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartDao shoppingCartDao;
    private final TicketDao ticketDao;

    public ShoppingCartServiceImpl(ShoppingCartDao shoppingCartDao, TicketDao ticketDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.ticketDao = ticketDao;
    }

    @Override
    public void addSession(PerformanceSession performanceSession, User user) {
        Ticket ticket = new Ticket();
        ticket.setPerformanceSession(performanceSession);
        ticket.setUser(user);
        ShoppingCart cartByUser = shoppingCartDao.getByUser(user);
        ticketDao.add(ticket);
        List<Ticket> tickets = cartByUser.getTickets();
        tickets.add(ticket);
        shoppingCartDao.update(cartByUser);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getTickets().clear();
        shoppingCartDao.update(shoppingCart);
    }
}
