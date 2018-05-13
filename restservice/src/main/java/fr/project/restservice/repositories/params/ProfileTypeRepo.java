package fr.project.restservice.repositories.params;

import fr.project.utils.entities.params.ProfileType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author BOURGEOIS Thibault
 * Date     12/05/2018
 * Time     16:41
 */
public interface ProfileTypeRepo extends CrudRepository<ProfileType, String> {
}
