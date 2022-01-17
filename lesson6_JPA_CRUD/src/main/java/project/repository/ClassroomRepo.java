package project.repository;

import org.springframework.data.repository.CrudRepository;
import project.model.Classroom;


public interface ClassroomRepo extends CrudRepository<Classroom, Integer> {
}
