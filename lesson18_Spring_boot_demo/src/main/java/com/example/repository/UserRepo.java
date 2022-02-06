package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface UserRepo extends CrudRepository<User, Integer> {
    @Query(value = "select s from User s where s.userName like concat('%' ,:name, '%')")
    ArrayList<User> findAllByName(@Param("name") String name);
}
