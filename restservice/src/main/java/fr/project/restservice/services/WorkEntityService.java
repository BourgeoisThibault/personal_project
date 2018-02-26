package fr.project.restservice.services;

import fr.project.restservice.entities.WorkEntity;
import fr.project.restservice.repositories.WorkEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     26/02/2018
 * Time     17:55
 */
@Service
public class WorkEntityService {

    @Autowired
    private final WorkEntityRepo workEntityRepo;

    public WorkEntityService(WorkEntityRepo workEntityRepo) {
        this.workEntityRepo = workEntityRepo;
    }

    public List<WorkEntity> getAllWorkEntities(){
        List<WorkEntity> workEntityList= (List<WorkEntity>) workEntityRepo.findAll();
        return workEntityList;
    }

}
