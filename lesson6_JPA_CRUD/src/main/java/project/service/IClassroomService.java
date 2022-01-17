package project.service;

import org.springframework.stereotype.Service;
import project.model.Classroom;

import java.util.List;


public interface IClassroomService {
    public List<Classroom> findAll();
}
