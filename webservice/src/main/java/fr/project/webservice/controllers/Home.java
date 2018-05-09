package fr.project.webservice.controllers;

import com.sun.deploy.net.HttpResponse;
import fr.project.webservice.service.loginServ;
import models.User_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @Autowired
    loginServ loginServ;

    @RequestMapping(value = "/", method = GET)
    public ModelAndView GetHome(HttpSession session) {
        if(session.getAttribute("isConnect")==null)
        {
            ModelAndView modelAndView = new ModelAndView("redirect:/login");
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView("home/index");
        modelAndView.addObject("session_first_name", session.getAttribute("first_name"));
        modelAndView.addObject("session_last_name", session.getAttribute("last_name"));
        modelAndView.addObject("session_profile", session.getAttribute("profile"));
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = GET)
    public String GetLogout(HttpSession session) {
        if (session.getAttribute("isConnect") == null)
            return "redirect:/";

        session.removeAttribute("isConnect");
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = GET)
    public ModelAndView GetLogin(@RequestParam(name = "error",required = false) String error,
            HttpSession session) {
        if (session.getAttribute("isConnect") != null)
        {
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView("home/login");
        modelAndView.addObject("error",error);
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = POST)
    public ModelAndView SetLogin(@RequestParam("login") String login,
                           @RequestParam("pass") String pass,
                           HttpSession session) throws InterruptedException {
        if (session.getAttribute("isConnect") != null)
        {
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            return modelAndView;
        }

        HttpStatus httpStatus = loginServ.connectUser(login,pass);

        if(httpStatus.equals(HttpStatus.OK))
        {
            User_ user_ = loginServ.getUserInformations(login);

            session.setAttribute("isConnect", true);
            session.setAttribute("first_name", user_.getFirstName());
            session.setAttribute("last_name", user_.getLastName());
            session.setAttribute("pseudo", user_.getPseudo());
            session.setAttribute("profile", "To define");

            return new ModelAndView("redirect:/");
        }

        session.removeAttribute("isConnect");

        if(httpStatus.equals(HttpStatus.NOT_FOUND))
            return new ModelAndView("redirect:/login?error=Utilisateur inconnu");

        if(httpStatus.equals(HttpStatus.UNAUTHORIZED))
            return new ModelAndView("redirect:/login?error=Mot de passe incorrect");

        return new ModelAndView("redirect:/login?error=Erreur inconnu");
    }
}
