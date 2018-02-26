package fr.project.restservice.repositories;

import fr.project.restservice.entities.Workplace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * @author BOURGEOIS Thibault
 * Date     26/02/2018
 * Time     15:56
 */
public interface WorkplaceRepo extends CrudRepository<Workplace,Long> {
}
