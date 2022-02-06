package com.service;

import com.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> findAll();

    public Student finById(int id);

    public void save(Student student);

    public void delete(int id);
}
