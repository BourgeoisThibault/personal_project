package fr.project.restservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.project.restservice.entities.UserProfile;
import fr.project.restservice.entities.Workplace;
import fr.project.restservice.services.UserProfileService;
import fr.project.restservice.services.WorkplaceService;
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
 * Time     18:00
 */
@RestController
@RequestMapping("/workplace")
public class WorkplaceController {

    @Autowired
    WorkplaceService workplaceService;

    @GetMapping("/")
    public ResponseEntity<List<Workplace>> getAllWorkplaces() throws JsonProcessingException {
        List<Workplace> workplaceList= workplaceService.getAllWorkplaces();
        return new ResponseEntity<List<Workplace>>(workplaceList, HttpStatus.OK);
    }
}
