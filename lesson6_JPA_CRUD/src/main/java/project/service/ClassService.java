package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.model.Classroom;
import project.repository.ClassroomRepo;

import java.util.List;
@Repository
public class ClassService implements IClassroomService{
    @Autowired
    ClassroomRepo classroomRepo;
    @Override
    public List<Classroom> findAll() {
        return (List<Classroom>) classroomRepo.findAll();
    }
}
