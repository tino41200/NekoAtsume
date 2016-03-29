package com.sprsec.dao;

import java.util.List;

import com.sprsec.model.Chat;

public interface ChatDAO {

    List<Chat> listeChat();

    Chat rechercheParNom(String nom);

    List<Chat> listeChatRare();

    List<Chat> listeChatCommun();
}
