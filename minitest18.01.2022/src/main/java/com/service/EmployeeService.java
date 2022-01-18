package com.service;

import com.model.Employee;
import com.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Repository
public class EmployeeService implements IEmployeeService{
    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public List<Employee> findAll() {
        return(List<Employee>) employeeRepo.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public Optional<Employee> finById(int id) {
        return employeeRepo.findById(id);
    }
    @Override
    public List<Employee> sort(){
        List<Employee> list = findAll();
        list.sort(Comparator.comparing(Employee::getAge));
        return list;
    }
    @Override
    public Employee findByName(String name) {
        for (Employee e : employeeRepo.findAll()) {
            if (e.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))) {
                return e;
            }
        }
        return null;
    }
}
