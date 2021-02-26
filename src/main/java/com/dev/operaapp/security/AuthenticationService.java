package com.dev.operaapp.security;

import com.dev.operaapp.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
