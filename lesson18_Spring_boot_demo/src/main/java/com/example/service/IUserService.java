package com.example.service;

import com.example.model.User;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<User> findAll(PageRequest of);
    public void save(User user);
    public void delete(int id);
    public Optional<User> findById(int id);
    public List<User> findByName(String name);
}
