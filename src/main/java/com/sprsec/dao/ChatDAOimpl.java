package com.sprsec.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprsec.model.Chat;

@Repository
public class ChatDAOimpl implements ChatDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Chat> listeChat() {
        Query query = openSession().createQuery("FROM Chat");
        return query.list();
    }

    @Override
    public Chat rechercheParNom(String nom) {
        //List<Chat>chat = new ArrayList<Chat>();
        Query query = openSession().createQuery("from Chat where nom ='" + nom + "'");

        return (Chat) query.uniqueResult();

    }

    @Override
    public List<Chat> listeChatRare() {
        Query query = openSession().createQuery("FROM Chat where rare=1");
        return query.list();
    }

    @Override
    public List<Chat> listeChatCommun() {
        Query query = openSession().createQuery("FROM Chat where rare=0");
        return query.list();
    }
}
