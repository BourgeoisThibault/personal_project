package fr.project.restservice.services;

import fr.project.restservice.entities.User;
import fr.project.restservice.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     26/02/2018
 * Time     17:54
 */
@Service
public class UserService {

    @Autowired
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers(){
        List<User> userList= (List<User>) userRepo.findAll();
        return userList;
    }

}
