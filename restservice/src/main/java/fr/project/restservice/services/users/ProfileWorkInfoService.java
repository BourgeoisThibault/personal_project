package fr.project.restservice.services.users;

import fr.project.restservice.repositories.users.ProfileWorkInfoRepo;
import fr.project.utils.entities.users.ProfileWorkInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author BOURGEOIS Thibault
 * Date     12/05/2018
 * Time     18:14
 */
@Service
public class ProfileWorkInfoService {
    @Autowired
    private ProfileWorkInfoRepo profileWorkInfoRepo;

    public ProfileWorkInfo saving(ProfileWorkInfo profileWorkInfo){
        return profileWorkInfoRepo.save(profileWorkInfo);
    }

}
