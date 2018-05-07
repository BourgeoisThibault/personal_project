package fr.project.webservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author BOURGEOIS Thibault
 * Date     04/05/2018
 * Time     11:45
 */

@Controller
public class Home {

    @Value("${link.rest}")
    private String linkREST;

    @RequestMapping(value = "/", method = GET)
    public String GetHome() {
        return "home/index";
    }

    @RequestMapping(value = "/login", method = GET)
    public String GetLogin(HttpSession session) {
        if (session.getAttribute("uid") != null)
            return "home/index";
        return "home/login";
    }

    @RequestMapping(value = "/login", method = POST)
    public String SetLogin(@RequestParam("login") String login,
                           @RequestParam("pass") String pass,
                           HttpSession session) throws InterruptedException {

        Thread.sleep(5000);

        if(login.equals("root") & pass.equals("root"))
        {
            session.setAttribute("uid", "toto");
            return "redirect:/";
        }else
        {
            session.removeAttribute("uid");
            return "home/login";
        }
    }
}
