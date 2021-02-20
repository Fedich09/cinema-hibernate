package com.dev.cinema.dbinit;

import com.dev.cinema.model.Role;
import com.dev.cinema.model.User;
import com.dev.cinema.service.RoleService;
import com.dev.cinema.service.UserService;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class InjectData {
    private final UserService userService;
    private final RoleService roleService;

    public InjectData(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void addRolesAndAdmin() {
        Role adminRole = new Role();
        adminRole.setRoleName("ADMIN");
        Role userRole = new Role();
        userRole.setRoleName("USER");
        User user = new User();
        user.setEmail("admin@gmail.com");
        user.setPassword("admin");
        user.setRole("ADMIN");
        userService.add(user);
        roleService.add(adminRole);
        roleService.add(userRole);
    }
}
