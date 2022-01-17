package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import project.model.Student;
import project.repository.ClassroomRepo;

import java.util.List;
import java.util.Optional;



public interface IStudentService {
    public List<Student> findAll();
    public void save(Student student);
    public void delete(int id);
    public Optional<Student> findById(int id);
}
