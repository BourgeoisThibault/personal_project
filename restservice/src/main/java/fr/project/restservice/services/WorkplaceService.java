package fr.project.restservice.services;

import fr.project.restservice.entities.Workplace;
import fr.project.restservice.repositories.WorkplaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     26/02/2018
 * Time     17:55
 */
@Service
public class WorkplaceService {

    @Autowired
    private final WorkplaceRepo workplaceRepo;

    public WorkplaceService(WorkplaceRepo workplaceRepo) {
        this.workplaceRepo = workplaceRepo;
    }

    public List<Workplace> getAllWorkplaces(){
        List<Workplace> workplaceList= (List<Workplace>) workplaceRepo.findAll();
        return workplaceList;
    }

}
