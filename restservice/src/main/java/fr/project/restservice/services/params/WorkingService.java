package fr.project.restservice.services.params;

import fr.project.restservice.repositories.params.WorkTypeRepo;
import fr.project.restservice.repositories.params.WorkingDepartmentRepo;
import fr.project.restservice.repositories.params.WorkingLocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author BOURGEOIS Thibault
 * Date     12/05/2018
 * Time     17:38
 */

@Service
public class WorkingService {

    @Autowired
    private WorkingDepartmentRepo workingDepartmentRepo;

    @Autowired
    private WorkingLocationRepo workingLocationRepo;

    @Autowired
    private WorkTypeRepo workTypeRepo;


}
