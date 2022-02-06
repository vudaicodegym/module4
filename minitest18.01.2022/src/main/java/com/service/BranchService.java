package com.service;

import com.model.Branch;
import com.repository.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BranchService implements IBranchService {

    @Autowired
    BranchRepo branchRepo;

    @Override
    public List<Branch> findAll() {
        return (List<Branch>) branchRepo.findAll();
    }
}
