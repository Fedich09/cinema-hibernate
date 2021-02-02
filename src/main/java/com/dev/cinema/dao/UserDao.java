package com.dev.cinema.dao;

import java.util.Optional;
import com.dev.cinema.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);
}
