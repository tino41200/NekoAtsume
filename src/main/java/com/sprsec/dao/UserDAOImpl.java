package com.sprsec.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprsec.model.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public User getUserById(int id) {
		List<User> userList = new ArrayList<User>();
		Query query = openSession().createQuery("from User u where u.id = :id");
		query.setParameter("id", id);
		userList = query.list();
		if(userList.size()>0)
			return userList.get(0);
		else
			return null;
	}

        @Override
	public User getUser(String login) {
		List<User> userList = new ArrayList<User>();
		Query query = openSession().createQuery("from User u where u.login = :login");
		query.setParameter("login", login);
		userList = query.list();
		if(userList.size()>0)
			return userList.get(0);
		else
			return null;
	}

        @Override
	public void add(User user) {
		openSession().persist(user);
	}

	@Override
	public void edit(User user) {
		User existingUser = (User) openSession().get(User.class, user.getId());
		//existingUser.setId(user.getId());
		existingUser.setLogin(user.getLogin());
		existingUser.setPassword(user.getPassword());
		
		openSession().save(existingUser);
		
	}

	
	
}
