package fr.project.restservice.repositories;

import fr.project.utils.entities.others.Sample;
import org.springframework.data.repository.CrudRepository;

/**
 * @author BOURGEOIS Thibault
 * Date     20/02/2018
 * Time     22:51
 */
public interface SampleRepo extends CrudRepository<Sample, Long> {
}
