package com.dev.operaapp.service.impl;

import com.dev.operaapp.dao.UserDao;
import com.dev.operaapp.model.User;
import com.dev.operaapp.service.UserService;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final PasswordEncoder encode;

    public UserServiceImpl(UserDao userDao, PasswordEncoder encode) {
        this.userDao = userDao;
        this.encode = encode;
    }

    @Override
    public User add(User user) {
        user.setPassword(encode.encode(user.getPassword()));
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
