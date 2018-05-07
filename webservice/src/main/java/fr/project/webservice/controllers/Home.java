package fr.project.webservice.controllers;

import fr.project.webservice.service.loginServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

        Thread.sleep(5000);

        if(loginServ.connectUser(login,pass))
        {
            session.setAttribute("isConnect", true);
            session.setAttribute("first_name", "Thibault");
            session.setAttribute("last_name", "BOURGEOIS");
            session.setAttribute("profile", "Administrateur");
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            return modelAndView;
        }else
        {
            session.removeAttribute("isConnect");
            ModelAndView modelAndView = new ModelAndView("redirect:/login?error=Erreur de connexion");
            return modelAndView;
        }
    }
}
