package com.dev.operaapp.dbinit;

import com.dev.operaapp.model.Role;
import com.dev.operaapp.model.User;
import com.dev.operaapp.service.RoleService;
import com.dev.operaapp.service.ShoppingCartService;
import com.dev.operaapp.service.UserService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class InjectData {
    private final UserService userService;
    private final RoleService roleService;
    private final ShoppingCartService shoppingCartService;

    public InjectData(UserService userService,
                      RoleService roleService,
                      ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.roleService = roleService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostConstruct
    private void addRolesAndAdmin() {
        Role adminRole = new Role();
        adminRole.setRoleName("ADMIN");
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setRoleName("USER");
        roleService.add(userRole);
        User user = new User();
        user.setEmail("admin@gmail.com");
        user.setPassword("1234");
        user.setRoles(List.of(roleService.getRoleByName("ADMIN")));
        shoppingCartService.registerNewShoppingCart(userService.add(user));
    }
}
