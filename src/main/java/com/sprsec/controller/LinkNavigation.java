package com.sprsec.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sprsec.model.User;
import com.sprsec.service.UserService;


@Controller
public class LinkNavigation {
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView indexPage(){
		return new ModelAndView("accueil");
	}
	
	@RequestMapping(value="/accueil", method=RequestMethod.GET)
	public String ModerationPage(Model model, Principal principal){
		model.addAttribute("title", "Moderation Page");
		String userName = principal.getName();
		model.addAttribute("message", "WELCOME mr "+userName);
		return "accueil";
	}
	
	@RequestMapping(value="/admin/first", method=RequestMethod.GET)
	public ModelAndView firstAdminPage(){
		return new ModelAndView("admin-first");
	}
	
	@RequestMapping(value="/admin/second", method=RequestMethod.GET)
	public ModelAndView secondAdminPage(){
		return new ModelAndView("admin-second");
	}
	
	//********ADD USER
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		return "registration";
	}
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {
		userService.addUser(user);
		
		model.addAttribute("log", true);
		model.addAttribute("userLog1", user.getLogin());
		model.addAttribute("userLog2", user.getPassword());
		return "login-form";
	}
	//*****END ADD USER

	//---------EDIT USER
	@RequestMapping(value = {"/edituser-{login}"}, method = RequestMethod.GET)
	public String getEdit(@PathVariable String login, ModelMap model){
		logger.debug("Received request to show edit page");
		
		User user = userService.getUser(login);
		model.addAttribute("user", user);
		model.addAttribute("login", user.getLogin());
		model.addAttribute("edit", true);
		
		return "edituser";
	}

	@RequestMapping(value = {"/edituser-{login}"}, method = RequestMethod.POST)
	public String postEdit(Model model, Principal principal){
		String userName = principal.getName();
		User exist = userService.getUser(userName);
		userService.updateUser(exist);
		model.addAttribute("log", true);
		model.addAttribute("userLog1", exist.getLogin());
		model.addAttribute("userLog2", exist.getPassword());
		return "login-form";
	}
	//------------END EDIT USER
	
	
	
	
}
