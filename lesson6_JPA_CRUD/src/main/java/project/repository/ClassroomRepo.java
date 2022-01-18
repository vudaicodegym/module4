package project.repository;

import org.springframework.data.repository.CrudRepository;
import project.model.ClassRoom;


public interface ClassroomRepo extends CrudRepository<ClassRoom, Integer> {
}
