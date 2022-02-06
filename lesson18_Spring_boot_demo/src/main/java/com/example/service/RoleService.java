package com.example.service;

import com.example.model.Role;
import com.example.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService implements IRoleService{
    @Autowired
    RoleRepo roleRepo;
    @Override
    public List<Role> findAll() {
        return (List<Role>) roleRepo.findAll();
    }
}
