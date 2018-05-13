package fr.project.restservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.project.restservice.services.params.ProfileService;
import fr.project.restservice.services.users.ProfileWorkInfoService;
import fr.project.utils.entities.others.Sample;
import fr.project.restservice.services.SampleService;
import fr.project.utils.entities.params.ProfileType;
import fr.project.utils.entities.users.ProfileAccount;
import fr.project.utils.entities.users.ProfileInfo;
import fr.project.utils.entities.users.ProfileWorkInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    ProfileService profileService;

    @GetMapping("/sample")
    public ResponseEntity<List<ProfileType>> getAllSample() throws JsonProcessingException {
        return new ResponseEntity<List<ProfileType>>(profileService.getAllProfileType(), HttpStatus.OK);
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
