package fr.project.restservice.repositories;

import fr.project.utils.entities.oldentities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author BOURGEOIS Thibault
 * Date     26/02/2018
 * Time     15:55
 */
public interface UserRepo extends CrudRepository<User,Long> {
    User findByPseudo(String pseudo);
}
