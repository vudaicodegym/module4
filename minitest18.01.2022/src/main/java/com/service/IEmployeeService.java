package com.service;

import com.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    public List<Employee> findAll();

    public void save(Employee employee);

    public void delete(int id);

    public Optional<Employee> finById(int id);

    public List<Employee> sort();

    public Employee findByName(String name);
}
