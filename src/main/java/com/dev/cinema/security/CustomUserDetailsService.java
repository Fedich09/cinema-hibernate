package com.dev.cinema.security;

import com.dev.cinema.service.UserService;
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
        com.dev.cinema.model.User user = userService.findByEmail(email).get();
        User.UserBuilder userBuilder = null;
        userBuilder = User.withUsername(user.getEmail());
        userBuilder.password(user.getPassword());
        userBuilder.roles(user.getRole());
        return userBuilder.build();
    }
}
