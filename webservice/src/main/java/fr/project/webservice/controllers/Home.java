package fr.project.webservice.controllers;

import fr.project.utils.entities.module.ChatRoom;
import fr.project.webservice.service.LoginService;
import fr.project.webservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private MessageService messageService;

    @RequestMapping(value = "/", method = GET)
    public ModelAndView GetHome(HttpSession session) throws Exception {
        if(session.getAttribute("isConnect")==null)
        {
            ModelAndView modelAndView = new ModelAndView("redirect:/sign/in");
            return modelAndView;
        }

        ChatRoom chatRoom = messageService.getChatRoom();

        ModelAndView modelAndView = new ModelAndView("home/index");

        modelAndView.addObject("chatroom", chatRoom);

        modelAndView.addObject("session_first_name", session.getAttribute("first_name"));
        modelAndView.addObject("session_last_name", session.getAttribute("last_name"));
        modelAndView.addObject("session_profile", session.getAttribute("profile"));

        return modelAndView;
    }

}
