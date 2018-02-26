package fr.project.restservice.repositories;

import fr.project.restservice.entities.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * @author BOURGEOIS Thibault
 * Date     26/02/2018
 * Time     15:55
 */
public interface UserProfileRepo extends CrudRepository<UserProfile,Long> {
}
