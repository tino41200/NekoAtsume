package com.sprsec.service;

import java.util.List;

import com.sprsec.model.Chat;



public interface ChatService {
	Chat rechercherParNom(String nom);
	List<Chat> listeChat();
	List<Chat> listeChatRare();
	List<Chat> listeChatCommun();
}
