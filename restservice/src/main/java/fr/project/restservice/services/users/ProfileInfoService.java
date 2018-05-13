package fr.project.restservice.services.users;

import fr.project.restservice.repositories.users.ProfileInfoRepo;
import fr.project.utils.entities.users.ProfileAccount;
import fr.project.utils.entities.users.ProfileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author BOURGEOIS Thibault
 * Date     12/05/2018
 * Time     18:14
 */
@Service
public class ProfileInfoService {
    @Autowired
    private ProfileInfoRepo profileInfoRepo;

    public ProfileInfo getOneInfoByAccount(ProfileAccount profileAccount) {
        return profileInfoRepo.getByProfileAccount(profileAccount);
    }
}
