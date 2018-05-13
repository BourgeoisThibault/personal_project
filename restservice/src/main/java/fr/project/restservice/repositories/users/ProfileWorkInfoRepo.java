package fr.project.restservice.repositories.users;

import fr.project.utils.entities.others.Sample;
import fr.project.utils.entities.users.ProfileWorkInfo;
import org.springframework.data.repository.CrudRepository;

public interface ProfileWorkInfoRepo extends CrudRepository<ProfileWorkInfo, Long> {
}
