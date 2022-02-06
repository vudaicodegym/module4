package com.repository;

import com.model.ClassRoom;
import org.springframework.data.repository.CrudRepository;

public interface ClassRepo extends CrudRepository<ClassRoom, Integer> {
}
