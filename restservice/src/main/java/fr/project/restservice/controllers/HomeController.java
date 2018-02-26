package fr.project.restservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.project.restservice.entities.Sample;
import fr.project.restservice.entities.User;
import fr.project.restservice.services.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     20/02/2018
 * Time     22:36
 */
@RestController
public class HomeController {

    @Value( "${docker.image.version}" )
    private String dockerImageVersion;

    @Value( "${docker.image.name}" )
    private String dockerImageName;

    @Value( "${docker.image.prefix}" )
    private String dockerImagePrefix;

    @Autowired
    SampleService sampleService;

    @GetMapping("/sample")
    public ResponseEntity<List<Sample>> getAllSample() throws JsonProcessingException {
        List<Sample> sampleList= sampleService.getAllSample();
        return new ResponseEntity<List<Sample>>(sampleList, HttpStatus.OK);
    }

    @GetMapping("/")
    public String homePage() throws UnknownHostException {
        String respons = new String();
        respons += "<H1>REST HOMEPAGE</H1>";
        respons += "<table style='font-weight: bold;' >";
        respons += "<tr>";
        respons += "<td>" + "Serveur" + "</td>";
        respons += "<td> &rarr; " + InetAddress.getLocalHost().getHostName() + "</td>";
        respons += "</tr>";
        respons += "<tr>";
        respons += "<td>" + "Image" + "</td>";
        respons += "<td> &rarr; " + dockerImagePrefix + dockerImageName + "</td>";
        respons += "</tr>";
        respons += "<tr>";
        respons += "<td>" + "Version" + "</td>";
        respons += "<td> &rarr; " + dockerImageVersion + "</td>";
        respons += "</tr>";
        respons += "</table>";

        return respons;
    }
}
