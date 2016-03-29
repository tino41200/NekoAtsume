package com.sprsec.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprsec.dao.UserDAO;
import com.sprsec.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public User getUser(String login){
		return userDAO.getUser(login);
	}

	public void addUser(User user) {
		userDAO.add(user);
	}

	@Override
	public void editUser(User user) {
		//userDAO.edit(user);
		Session session = sessionFactory.getCurrentSession();
		User exist = (User)session.get(User.class, user.getId());
		exist.setLogin(user.getLogin());
		exist.setPassword(user.getPassword());
		session.save(exist);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDAO.getUserById(id);
	}

	@Override
	public void updateUser(User user) {
		User entity = userDAO.getUserById(user.getId());
		if(entity!=null){
			entity.setLogin(user.getLogin());
			entity.setPassword(user.getPassword());
		}
	}

	@Override
	public List<User> listeUser() {
		// TODO Auto-generated method stub
		return userDAO.listeUser();
	}

	@Override
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}
}
