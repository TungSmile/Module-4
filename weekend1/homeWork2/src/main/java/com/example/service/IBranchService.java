package com.example.service;

import com.example.entity.Branch;

import java.util.List;

public interface IBranchService {
    List<Branch> getAll();
    void addNewBranch(Branch branch);
    void deleteBranch(Branch branch);
}
