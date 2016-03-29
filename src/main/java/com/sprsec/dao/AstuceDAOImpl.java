package com.sprsec.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprsec.model.AjoutAstuce;
import com.sprsec.model.Astuce;
import com.sprsec.model.User;

@Repository
public class AstuceDAOImpl implements AstuceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Astuce> getAllAstuce() {
        Query query = openSession().createQuery("from Astuce");
        return query.list();
    }

    @Override
    public Astuce getAstuceById(int id) {
        Query query = openSession().createQuery("from Astuce where idastuce=" + id);
        return (Astuce) query.uniqueResult();
    }

    @Override
    public List<Astuce> getAstuce(String chatname) {
        Query query = openSession().createQuery("from Astuce where nomchat='" + chatname + "'");
        return query.list();
    }

    @Override
    public void addAstuce(AjoutAstuce astuce) {
        System.out.println("astuce ajouté");
        openSession().persist(astuce);
    }

    @Override
    public void addPlus(Astuce astuce) {
        Astuce existingAstuce = (Astuce) openSession().get(Astuce.class, astuce.getIdastuce());
        existingAstuce.setNomchat(astuce.getNomchat());
        existingAstuce.setUsername(astuce.getUsername());
        System.out.println("pour + 1");
        existingAstuce.setVoteplus(astuce.getVoteplus() + 1);
        existingAstuce.setVote_moins(astuce.getVote_moins());
        openSession().save(existingAstuce);
    }

    @Override
    public void addMoins(Astuce astuce) {
        Astuce existingAstuce = (Astuce) openSession().get(Astuce.class, astuce.getIdastuce());
        existingAstuce.setNomchat(astuce.getNomchat());
        existingAstuce.setUsername(astuce.getUsername());
        System.out.println("contre + 1");
        existingAstuce.setVoteplus(astuce.getVoteplus());
        existingAstuce.setVote_moins(astuce.getVote_moins() + 1);
        openSession().save(existingAstuce);
    }

    @Override
    public void deleteAstuce(int id) {
        /*
	 Query query = openSession().createQuery("FROM User where id="+id);
		User user = (User)query.uniqueResult();
		System.out.println(user.getLogin() + " : " +user.getPassword());
		if(null!=user){
		openSession().delete(user);}	
         */
        Query query = openSession().createQuery("FROM Astuce where idastuce=" + id);
        Astuce astuce = (Astuce) query.uniqueResult();
        openSession().delete(astuce);
    }

}
