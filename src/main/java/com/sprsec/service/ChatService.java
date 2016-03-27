package com.sprsec.service;

import java.util.List;

import com.sprsec.model.Chat;



public interface ChatService {
	Chat rechercherParNom(String nom);
        Chat rechercherParNomJaponais(String nomJaponais);
	List<Chat> listeChat();
}
