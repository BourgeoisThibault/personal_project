package fr.project.restservice.repositories;

import fr.project.utils.entities.oldentities.Workplace;
import org.springframework.data.repository.CrudRepository;

/**
 * @author BOURGEOIS Thibault
 * Date     26/02/2018
 * Time     15:56
 */
public interface WorkplaceRepo extends CrudRepository<Workplace,Long> {
}
