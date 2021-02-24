package com.dev.operaapp.service;

import com.dev.operaapp.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
