package com.dev.cinema.service.impl;

import com.dev.cinema.config.SecurityConfig;
import com.dev.cinema.dao.UserDao;
import com.dev.cinema.model.User;
import com.dev.cinema.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final SecurityConfig securityConfig;

    public UserServiceImpl(UserDao userDao, SecurityConfig securityConfig) {
        this.userDao = userDao;
        this.securityConfig = securityConfig;
    }

    @Override
    public User add(User user) {
        user.setPassword(securityConfig.getEncoder().encode(user.getPassword()));
        return userDao.add(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email).orElseThrow(() ->
                new RuntimeException("Can't get by email " + email));
    }

    @Override
    public User get(Long id) {
        return userDao.get(id).orElseThrow(() ->
                new RuntimeException("Can't get by id" + id));
    }
}
