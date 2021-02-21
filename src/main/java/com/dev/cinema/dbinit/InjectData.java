package com.dev.cinema.dbinit;

import com.dev.cinema.config.SecurityConfig;
import com.dev.cinema.model.Role;
import com.dev.cinema.model.User;
import com.dev.cinema.service.RoleService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class InjectData {
    private final UserService userService;
    private final RoleService roleService;
    private final ShoppingCartService shoppingCartService;
    private final SecurityConfig securityConfig;

    public InjectData(UserService userService,
                      RoleService roleService,
                      ShoppingCartService shoppingCartService,
                      SecurityConfig securityConfig) {
        this.userService = userService;
        this.roleService = roleService;
        this.shoppingCartService = shoppingCartService;
        this.securityConfig = securityConfig;
    }

    @PostConstruct
    private void addRolesAndAdmin() {
        Role adminRole = new Role();
        adminRole.setRoleName("ADMIN");
        Role userRole = new Role();
        roleService.add(adminRole);
        userRole.setRoleName("USER");
        roleService.add(userRole);
        User user = new User();
        user.setEmail("admin@gmail.com");
        user.setPassword(securityConfig.getEncoder().encode("admin"));
        user.setRoles(List.of(roleService.getRoleByName("ADMIN")));
        shoppingCartService.registerNewShoppingCart(userService.add(user));
    }
}
