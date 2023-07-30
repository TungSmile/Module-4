package com.example.repository;

import com.example.entity.Branch;
import org.springframework.data.repository.CrudRepository;

public interface IBranchRepo extends CrudRepository<Branch,Integer> {
}
