package com.sprsec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sprsec.model.User;
import com.sprsec.service.UserService;

@Controller
public class SecurityNavigation {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/", "/user-login.html"}, method = RequestMethod.GET)
    public ModelAndView loginForm() {

        return new ModelAndView("login-form");

    }

    @RequestMapping(value = {"/user-login"}, method = RequestMethod.POST)
    public String loginOk(@RequestParam("login") String login, ModelMap mod) {
        User existinguser = userService.getUser(login);
        if (login.equals("admin")) {
            System.out.println("je suis l'administrateur");
            mod.addAttribute("adm", true);
        }
        System.out.println("je suis un utilisateur");
        mod.addAttribute("userlog", existinguser.getLogin());
        return "acceuil";
    }

    @RequestMapping(value = "/error-login", method = RequestMethod.GET)
    public ModelAndView invalidLogin() {
        ModelAndView modelAndView = new ModelAndView("login-form");
        modelAndView.addObject("error", true);
        return modelAndView;
    }

}
