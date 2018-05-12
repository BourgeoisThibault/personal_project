package fr.project.restservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.project.utils.entities.oldentities.User;
import fr.project.utils.entities.others.Error;
import fr.project.restservice.services.UserService;
import methods.Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.ws.rs.core.MediaType;
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

    @RequestMapping(path = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity createNewUser(@RequestBody User user) {
        User newUser = userService.getOneUserByPseudo(user.getPseudo());
        if (newUser == null) {
            newUser = userService.createOneUser(user);
            return new ResponseEntity(newUser, HttpStatus.OK);
        } else {
            Error error = new Error("409","User already exist");
            return new ResponseEntity(error, HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(path = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity updateUser(@RequestBody User user) {

        User updateUser = userService.updateUser(user);
        if (updateUser != null) {
            return new ResponseEntity(updateUser, HttpStatus.OK);
        } else {
            Error error = new Error("404","User " + user.getPseudo() + " (" + user.getId() + ")" + " not found");
            return new ResponseEntity(error, HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity getUserById(@PathVariable Long id) {
        User user = userService.getOneUser(id);
        if (user != null)
            return new ResponseEntity(user,HttpStatus.OK);
        else {
            Error error = new Error("404","User " + id + " not found");
            return new ResponseEntity(error, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/login/{pseudo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity getUserByPseudo(@PathVariable String pseudo) {
        User user = userService.getOneUserByPseudo(pseudo);
        if (user != null)
            return new ResponseEntity(user,HttpStatus.OK);
        else {
            Error error = new Error("404","User " + pseudo + " not found");
            return new ResponseEntity(error, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/checking")
    public ResponseEntity checkingUser(
            @RequestHeader(value = "login") String login,
            @RequestHeader(value = "pass") String pass) {

        try {

            User user = userService.getOneUserByPseudo(login);

            if(user == null)
                return new ResponseEntity(HttpStatus.NOT_FOUND);

            if (user.getPassword().equals(Crypt.getHash(pass)))
                return new ResponseEntity(HttpStatus.OK);
            else
                return new ResponseEntity(HttpStatus.UNAUTHORIZED);

        } catch (HttpClientErrorException ex) {
            return new ResponseEntity(ex.getStatusCode());
        }

    }

}
