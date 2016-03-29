package com.sprsec.controller;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sprsec.model.AjoutAstuce;
import com.sprsec.model.Astuce;
import com.sprsec.model.Chat;
import com.sprsec.model.User;
import com.sprsec.service.AstuceService;
import com.sprsec.service.ChatService;

@Controller
public class ChatNavigation {

    @Resource(name = "chatService")
    ChatService chatService;

    @Resource(name = "astuceService")
    AstuceService astuceService;

    @RequestMapping(value = {"/chats"}, method = RequestMethod.GET)
    public String listChat(Model model) {
        List<Chat> chats = chatService.listeChat();
        model.addAttribute("listechat", chats);
        model.addAttribute("find", false);
        return "chats";
    }

    @RequestMapping(value = {"/rare"}, method = RequestMethod.GET)
    public String listChatRare(Model model) {
        List<Chat> chats = chatService.listeChatRare();
        model.addAttribute("listechat", chats);
        model.addAttribute("find", false);
        return "chats";
    }

    @RequestMapping(value = {"/communs"}, method = RequestMethod.GET)
    public String listChatCommun(Model model) {
        List<Chat> chats = chatService.listeChatCommun();
        model.addAttribute("listechat", chats);
        model.addAttribute("find", false);
        return "chats";
    }

    @RequestMapping(value = {"/admin-chats"}, method = RequestMethod.GET)
    public String listChatAdm(Model model) {
        List<Chat> chats = chatService.listeChat();
        model.addAttribute("listechat", chats);
        model.addAttribute("find", false);
        return "admin-chats";
    }

    @RequestMapping(value = {"/astuces"}, method = RequestMethod.GET)
    public String listAstuce(Model model) {
        List<Astuce> listAstuce = astuceService.getAllAstuce();
        model.addAttribute("listeastuce", listAstuce);
        Astuce astc = new Astuce();
        model.addAttribute("voteplus", astc);
        return "astuce";
    }

    @RequestMapping(value = {"/admin-astuces"}, method = RequestMethod.GET)
    public String listAstuceAdm(Model model) {
        List<Astuce> listAstuce = astuceService.getAllAstuce();
        model.addAttribute("listeastuce", listAstuce);
        return "admin-astuces";
    }

    @RequestMapping(value = {"/chats"}, method = RequestMethod.POST)
    public String rechercheChat(@RequestParam("searchText") String nom, Model model) {
        System.out.println(nom);
        Chat chats = chatService.rechercherParNom(nom);
        model.addAttribute("listechat", chats);
        model.addAttribute("find", true);
        return "chats";
    }

    @RequestMapping(value = {"/astuce-{chatname}"}, method = RequestMethod.GET)
    public String getCatAstuce(@PathVariable("chatname") String chatnom, Model model, Principal principal) {
        System.out.println(chatnom);
        Chat chats = chatService.rechercherParNom(chatnom);
        model.addAttribute("chat", chats);
        model.addAttribute("astuce", true);

        AjoutAstuce ajoutAstuce = new AjoutAstuce();
        model.addAttribute("ajout", ajoutAstuce);
        List<Astuce> astuce = astuceService.getAstuce(chatnom);
        model.addAttribute("listastuce", astuce);

        Astuce astc = new Astuce();
        model.addAttribute("voteplus", astc);

        return "chats";
    }

    @RequestMapping(value = {"/astuce-{chatname}"}, method = RequestMethod.POST)
    public String saveAstuce(@ModelAttribute("ajout") AjoutAstuce ajout, @PathVariable("chatname") String chatnom,
            ModelMap model) {
        astuceService.addAstuce(ajout);
        Chat chats = chatService.rechercherParNom(chatnom);
        model.addAttribute("chat", chats);
        model.addAttribute("astuce", true);
        List<Astuce> astuce = astuceService.getAstuce(chatnom);
        model.addAttribute("listastuce", astuce);
        return "chats";
    }

    @RequestMapping(value = {"/voteplus-{idastuce}"}, method = RequestMethod.POST)
    public String votePlus(@PathVariable("idastuce") int id, Model model) {
        Astuce astc = astuceService.getAstuceById(id);
        System.out.println(astc.getNomchat() + " " + astc.getIdastuce());
        astuceService.addPlus(astc);
        Chat chats = chatService.rechercherParNom(astc.getNomchat());
        model.addAttribute("chat", chats);
        model.addAttribute("astuce", true);
        List<Astuce> astuce = astuceService.getAstuce(astc.getNomchat());
        model.addAttribute("listastuce", astuce);
        AjoutAstuce ajoutAstuce = new AjoutAstuce();
        model.addAttribute("ajout", ajoutAstuce);
        return "chats";
    }

    @RequestMapping(value = {"/astuceplus-{idastuce}"}, method = RequestMethod.POST)
    public String astucePlus(@PathVariable("idastuce") int id, Model model) {
        Astuce astc = astuceService.getAstuceById(id);
        System.out.println(astc.getNomchat() + " " + astc.getIdastuce());
        astuceService.addPlus(astc);
        List<Astuce> listAstuce = astuceService.getAllAstuce();
        model.addAttribute("listeastuce", listAstuce);
        return "astuce";
    }

    @RequestMapping(value = {"/votemoins-{idastuce}"}, method = RequestMethod.POST)
    public String voteMoins(@PathVariable("idastuce") int id, Model model) {
        Astuce astc = astuceService.getAstuceById(id);
        System.out.println(astc.getNomchat() + " " + astc.getIdastuce());
        astuceService.addMoins(astc);
        Chat chats = chatService.rechercherParNom(astc.getNomchat());
        model.addAttribute("chat", chats);
        model.addAttribute("astuce", true);
        List<Astuce> astuce = astuceService.getAstuce(astc.getNomchat());
        model.addAttribute("listastuce", astuce);
        AjoutAstuce ajoutAstuce = new AjoutAstuce();
        model.addAttribute("ajout", ajoutAstuce);
        return "chats";
    }

    @RequestMapping(value = {"/astucemoins-{idastuce}"}, method = RequestMethod.POST)
    public String astuceMoins(@PathVariable("idastuce") int id, Model model) {
        Astuce astc = astuceService.getAstuceById(id);
        System.out.println(astc.getNomchat() + " " + astc.getIdastuce());
        astuceService.addPlus(astc);
        List<Astuce> listAstuce = astuceService.getAllAstuce();
        model.addAttribute("listeastuce", listAstuce);
        return "astuce";
    }

    /*
		 @RequestMapping("/supprimer-{id}")
	public String removeUser(@PathVariable("id")int id, Model model){
		userService.deleteUser(id);
		List<User>users = userService.listeUser();
		model.addAttribute("listuser", users);
		return "admin-users";
	}
     */
    @RequestMapping(value = "/supprimerastuce-{id}")
    public String removeAstuce(@PathVariable("id") int id, Model model) {
        astuceService.deleteAstuce(id);
        List<Astuce> listAstuce = astuceService.getAllAstuce();
        model.addAttribute("listeastuce", listAstuce);
        return "admin-astuces";
    }

}
