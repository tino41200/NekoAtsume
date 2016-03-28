package com.sprsec.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprsec.model.Astuce;

@Repository
public class AstuceDAOImpl implements AstuceDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Astuce> getAllAstuce() {
		Query query = openSession().createQuery("from Astuce");
		return query.list();
	}

	@Override
	public List<Astuce> getAstuce(String chatname, String username) {
		Query query = openSession().createQuery("from Astuce where chat_nom='"+chatname+"' and username='"+username+"'");
		return query.list();
	}

	@Override
	public void addAstuce(Astuce astuce) {
		openSession().persist(astuce);
	}

	@Override
	public void addMoins(Astuce astuce) {
		openSession().persist(astuce);
	}

	@Override
	public void addPlus(Astuce astuce) {
		openSession().persist(astuce);
		
	}
	
	
	

}
