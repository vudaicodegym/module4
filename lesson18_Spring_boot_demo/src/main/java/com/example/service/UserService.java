package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepo userRepo;
    @Override
    public List<User> findAll(PageRequest of) {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepo.findById(id);
    }
    @Override
    public ArrayList<User> findByName(String name){
        return userRepo.findAllByName(name);
    }
}
