package fr.project.restservice.repositories.params;

import fr.project.utils.entities.params.ProfileType;
import fr.project.utils.entities.params.WorkType;
import org.springframework.data.repository.CrudRepository;

public interface WorkTypeRepo extends CrudRepository<WorkType, String> {
}
