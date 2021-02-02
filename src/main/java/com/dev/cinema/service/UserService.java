package com.dev.cinema.service;

import java.util.Optional;
import com.dev.cinema.model.User;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);
}
