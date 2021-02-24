package com.dev.operaapp.security;

import com.dev.operaapp.model.Role;
import com.dev.operaapp.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.dev.operaapp.model.User user = userService.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("Can't find by email " + email));
        User.UserBuilder userBuilder = null;
        userBuilder = User.withUsername(user.getEmail());
        userBuilder.password(user.getPassword());
        userBuilder.roles(user.getRoles().stream()
                .map(Role::getRoleName)
                .toArray(String[]::new));
        return userBuilder.build();
    }
}
