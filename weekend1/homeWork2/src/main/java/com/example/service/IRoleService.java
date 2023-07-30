package com.example.service;

import com.example.entity.Role;

import java.util.List;

public interface IRoleService {
    List<Role> getAll();
    void addNewRole(Role role);
    void deleteRole(Role role);
}
