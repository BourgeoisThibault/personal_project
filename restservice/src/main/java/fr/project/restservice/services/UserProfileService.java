package fr.project.restservice.services;

import fr.project.restservice.entities.UserProfile;
import fr.project.restservice.entities.WorkEntity;
import fr.project.restservice.entities.Workplace;
import fr.project.restservice.repositories.UserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     26/02/2018
 * Time     15:49
 */
@Service
public class UserProfileService {

    @Autowired
    private final UserProfileRepo userProfileRepo;

    public UserProfileService(UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }

    public List<UserProfile> getAllUserProfile(){
        List<UserProfile> userProfileList= (List<UserProfile>) userProfileRepo.findAll();
        return userProfileList;
    }
    
}
