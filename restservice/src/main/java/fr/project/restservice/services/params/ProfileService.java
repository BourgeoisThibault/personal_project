package fr.project.restservice.services.params;

import fr.project.restservice.repositories.params.ProfileTypeRepo;
import fr.project.utils.entities.oldentities.User;
import fr.project.utils.entities.params.ProfileType;
import fr.project.utils.entities.users.ProfileAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     12/05/2018
 * Time     16:43
 */

@Service
public class ProfileService {

    @Autowired
    private ProfileTypeRepo profileTypeRepo;

    public List<ProfileType> getAllProfileType(){
        List<ProfileType> profileTypeList= (List<ProfileType>) profileTypeRepo.findAll();
        return profileTypeList;
    }


}
