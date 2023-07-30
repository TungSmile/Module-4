package com.example.model.repository;

import com.example.model.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRoleRepo  extends PagingAndSortingRepository<Role,Integer> {
}
