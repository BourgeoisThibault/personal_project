package fr.project.webservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author BOURGEOIS Thibault
 * Date     04/05/2018
 * Time     11:45
 */

@Controller
public class Home {

    @RequestMapping(value = "/", method = GET)
    public String GetHome() {
        return "home/index";
    }

}
