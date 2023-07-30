package com.example.service.impl;

import com.example.entity.Role;
import com.example.repository.IBranchRepo;
import com.example.repository.IRoleRepo;
import com.example.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepo iRoleRepo;

    @Override
    public List<Role> getAll() {
        return (List<Role>) iRoleRepo.findAll();
    }

    @Override
    public void addNewRole(Role role) {
        iRoleRepo.save(role);
    }

    @Override
    public void deleteRole(Role role) {
        iRoleRepo.delete(role);
    }
}
