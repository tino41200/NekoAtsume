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
public class ChatDAOimpl implements ChatDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession(){
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
		Query query = openSession().createQuery("from Chat where nom ='"+nom+"'");
//		query.setParameter("nom", nom);
//		chat = query.list();
//		if(chat.size()>0)
//			return chat.get(0);
//		else
//			return null;
		return (Chat) query.uniqueResult();
		
	}
        
        	@Override
	public Chat rechercheParNomJaponais(String nomJaponais) {
		Query query = openSession().createQuery("from Chat where nom_japonais ='"+nomJaponais+"'");
		return (Chat) query.uniqueResult();
		
	}
}
