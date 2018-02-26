package fr.project.restservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.project.restservice.entities.User;
import fr.project.restservice.services.UserProfileService;
import fr.project.restservice.services.UserService;
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
 * Time     16:21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() throws JsonProcessingException {
        List<User> userList= userService.getAllUsers();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

}
