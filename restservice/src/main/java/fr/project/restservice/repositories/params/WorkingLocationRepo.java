package fr.project.restservice.repositories.params;

import fr.project.utils.entities.params.WorkingLocation;
import org.springframework.data.repository.CrudRepository;

public interface WorkingLocationRepo extends CrudRepository<WorkingLocation, String> {
}
