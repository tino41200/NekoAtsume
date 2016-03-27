package com.sprsec.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sprsec.model.Chat;
import com.sprsec.service.ChatService;

@Controller
public class ChatNavigation {
	
	@Resource(name="chatService")
	ChatService chatService;
	
	@RequestMapping(value = {"/chats"}, method = RequestMethod.GET)
	public String listChat(Model model){
		List<Chat>chats = chatService.listeChat();
		model.addAttribute("listechat", chats);
		model.addAttribute("find", false);
		return "chats";
	}
	
	@RequestMapping(value = {"/chats"}, method = RequestMethod.POST)
	public String rechercheChat(@RequestParam("searchText")String nom, Model model){
		System.out.println(nom);
		Chat chats = chatService.rechercherParNom(nom);
		model.addAttribute("listechat", chats);
		model.addAttribute("find", true);
		return "chats";
	}
	
	@RequestMapping(value = {"/{chatname}"}, method = RequestMethod.GET)
	public String getCatAstuce(@PathVariable("chatname") String chatnom, Model model){
                System.out.println(chatnom);
                
		Chat chats = chatService.rechercherParNom(chatnom);
                
		model.addAttribute("chat", chats);
		model.addAttribute("astuce", true);     
               
		return "chats";
        }  
}
