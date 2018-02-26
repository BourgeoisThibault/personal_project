package fr.project.restservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.project.restservice.entities.User;
import fr.project.restservice.entities.UserProfile;
import fr.project.restservice.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     26/02/2018
 * Time     16:06
 */
@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    @GetMapping("/")
    public ResponseEntity<List<UserProfile>> getAllUserProfiles() throws JsonProcessingException {
        List<UserProfile> userProfileList= userProfileService.getAllUserProfile();
        return new ResponseEntity<List<UserProfile>>(userProfileList, HttpStatus.OK);
    }
}
