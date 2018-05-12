package fr.project.restservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.project.utils.entities.oldentities.WorkEntity;
import fr.project.restservice.services.WorkEntityService;
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
 * Time     18:02
 */
@RestController
@RequestMapping("/workentity")
public class WorkEntityController {

    @Autowired
    WorkEntityService workEntityService;

    @GetMapping("/")
    public ResponseEntity<List<WorkEntity>> getAllWorkEntities() throws JsonProcessingException {
        List<WorkEntity> workEntityList= workEntityService.getAllWorkEntities();
        return new ResponseEntity<List<WorkEntity>>(workEntityList, HttpStatus.OK);
    }

}
