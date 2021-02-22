package com.dev.cinema.service.impl;

import com.dev.cinema.config.AppConfig;
import com.dev.cinema.dao.UserDao;
import com.dev.cinema.model.User;
import com.dev.cinema.service.UserService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final AppConfig appConfig;

    public UserServiceImpl(UserDao userDao, AppConfig appConfig) {
        this.userDao = userDao;
        this.appConfig = appConfig;
    }

    @Override
    public User add(User user) {
        user.setPassword(appConfig.getEncoder().encode(user.getPassword()));
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id).orElseThrow(() ->
                new RuntimeException("Can't get by id" + id));
    }
}
