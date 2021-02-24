package com.dev.operaapp.dao;

import com.dev.operaapp.model.Role;
import java.util.Optional;

public interface RoleDao {
    void add(Role role);

    Optional<Role> getRoleByName(String roleName);
}
