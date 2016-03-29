package com.sprsec.dao;

import java.util.List;

import com.sprsec.model.AjoutAstuce;
import com.sprsec.model.Astuce;

public interface AstuceDAO {
    //récupérer les astuces de tous les chats

    public List<Astuce> getAllAstuce();

    //récupérer les astuces du chats
    public List<Astuce> getAstuce(String chatname);

    //ajouter une astuce pour un chat
    public void addAstuce(AjoutAstuce Ajoutastuce);

    public Astuce getAstuceById(int id);

    public void addPlus(Astuce astuce);

    public void addMoins(Astuce astuce);

    public void deleteAstuce(int id);
}
