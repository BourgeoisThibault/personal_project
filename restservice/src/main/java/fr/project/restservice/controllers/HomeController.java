package fr.project.restservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.project.restservice.entities.Sample;
import fr.project.restservice.services.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     20/02/2018
 * Time     22:36
 */
@RestController
public class HomeController {

    @Autowired
    SampleService sampleService;

    @GetMapping("/sample")
    public ResponseEntity<List<Sample>> getAllSample() throws JsonProcessingException {
        List<Sample> sampleList= sampleService.getAllSample();
        return new ResponseEntity<List<Sample>>(sampleList, HttpStatus.OK);
    }

    @GetMapping("/")
    public String homePage(){
        return "<H1>JOBSWITCH REST HOMEPAGE</H1>";
    }
}
