package com.example.repository;

import com.example.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepo extends CrudRepository<Role,Integer> {
}
