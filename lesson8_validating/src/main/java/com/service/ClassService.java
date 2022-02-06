package com.service;

import com.model.ClassRoom;
import com.repository.ClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassService implements IClassService {
    @Autowired
    ClassRepo classRepo;

    @Override
    public List<ClassRoom> findAll() {
        return (List<ClassRoom>) classRepo.findAll();
    }
}
