package fr.project.restservice.repositories.params;

import fr.project.utils.entities.params.WorkingDepartment;
import org.springframework.data.repository.CrudRepository;

public interface WorkingDepartmentRepo extends CrudRepository<WorkingDepartment, String> {
}
