package com.example.service.impl;

import com.example.entity.Branch;
import com.example.repository.IBranchRepo;
import com.example.service.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements IBranchService {
    @Autowired
    IBranchRepo iBranchRepo;

    @Override
    public List<Branch> getAll() {
        return (List<Branch>) iBranchRepo.findAll();
    }

    @Override
    public void addNewBranch(Branch branch) {
        iBranchRepo.save(branch);
    }

    @Override
    public void deleteBranch(Branch branch) {
        iBranchRepo.delete(branch);
    }
}
