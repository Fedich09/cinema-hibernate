package com.dev.operaapp.security.impl;

import com.dev.operaapp.model.User;
import com.dev.operaapp.security.AuthenticationService;
import com.dev.operaapp.service.RoleService;
import com.dev.operaapp.service.ShoppingCartService;
import com.dev.operaapp.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setRoles(List.of(roleService.getRoleByName("USER")));
        user.setPassword(password);
        User userFromDb = userService.add(user);
        shoppingCartService.registerNewShoppingCart(userFromDb);
        return userFromDb;
    }
}
