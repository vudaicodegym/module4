package project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.model.Student;
import project.repository.StudentRepo;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentService implements IStudentService {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepo.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void delete(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentRepo.findById(id);
    }
}
