package com.repository;

import com.model.Branch;
import org.springframework.data.repository.CrudRepository;

public interface BranchRepo extends CrudRepository<Branch, Integer> {
}
