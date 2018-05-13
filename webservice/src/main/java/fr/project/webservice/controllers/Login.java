package fr.project.webservice.controllers;

import fr.project.utils.entities.oldentities.User;
import fr.project.utils.entities.users.ProfileInfo;
import fr.project.webservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author BOURGEOIS Thibault
 * Date     10/05/2018
 * Time     01:26
 */

@Controller
@RequestMapping(value="/sign")
public class Login {


    @Autowired
    LoginService loginService;


    @RequestMapping(value = "/out", method = GET)
    public String GetLogout(HttpSession session) {

        if (session.getAttribute("isConnect") == null)
            return "redirect:../";

        session.removeAttribute("isConnect");
        return "redirect:../";
    }

    @RequestMapping(value = "/forgot", method = GET)
    public ModelAndView GetNewPassword(HttpSession session) {

        if (session.getAttribute("isConnect") != null)
            session.removeAttribute("isConnect");

        ModelAndView modelAndView = new ModelAndView("account/findPassword");
        return modelAndView;
    }

    @RequestMapping(value = "/forgot", method = POST)
    public ModelAndView setNewPass(@RequestParam("mail") String mail,
                                 HttpSession session) throws UnsupportedEncodingException {
        if (session.getAttribute("isConnect") != null)
            session.removeAttribute("isConnect");

        loginService.sendNewPassword(mail);

        return new ModelAndView("redirect:../sign/in?message=" + URLEncoder.encode("Email envoyé", "UTF-8"));

    }

    @RequestMapping(value = "/in", method = GET)
    public ModelAndView GetLogin(@RequestParam(name = "error",required = false) String error,
                                 @RequestParam(name = "message",required = false) String message,
                                 HttpSession session) {

        if (session.getAttribute("isConnect") != null)
        {
            ModelAndView modelAndView = new ModelAndView("redirect:../");
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView("account/login");
        modelAndView.addObject("error",error);
        modelAndView.addObject("message",message);
        return modelAndView;
    }

    @RequestMapping(value = "/in", method = POST)
    public ModelAndView SetLogin(@RequestParam("login") String login,
                                 @RequestParam("pass") String pass,
                                 HttpSession session) throws InterruptedException {
        if (session.getAttribute("isConnect") != null)
        {
            ModelAndView modelAndView = new ModelAndView("redirect:../");
            return modelAndView;
        }

        try {
            ProfileInfo profileInfo = loginService.authentificateUser(login,pass);

            session.setAttribute("isConnect", true);
            session.setAttribute("first_name", profileInfo.getFirstName());
            session.setAttribute("last_name", profileInfo.getLastName());
            session.setAttribute("pseudo", profileInfo.getProfileAccount().getPseudo());
            session.setAttribute("profile", "To define");

            return new ModelAndView("redirect:../");
        } catch (Exception e) {
            return new ModelAndView("redirect:../sign/in?error="+e.getMessage());
        }

    }
}
