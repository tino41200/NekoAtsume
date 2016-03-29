package com.sprsec.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprsec.model.Chat;
import com.sprsec.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User getUserById(int id) {
        List<User> userList = new ArrayList<User>();
        Query query = openSession().createQuery("from User u where u.id = :id");
        query.setParameter("id", id);
        userList = query.list();
        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    public User getUser(String login) {
        List<User> userList = new ArrayList<User>();
        Query query = openSession().createQuery("from User u where u.login = :login");
        query.setParameter("login", login);
        userList = query.list();
        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }

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

    /*
	 @Override
	public List<Chat> listeChat() {
		Query query = openSession().createQuery("FROM Chat");
		return query.list();
	}
     */
    @Override
    public List<User> listeUser() {
        Query query = openSession().createQuery("FROM User");
        return query.list();
    }

    @Override
    public void deleteUser(int id) {
        /*
		 Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person)session.load(Person.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
		
		User u = (User)openSession().load(User.class, new Integer(id));
		if(null != u){
			openSession().delete(u);
		}
		
		*
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("FROM Person as p LEFT JOIN FETCH p.creditCards WHERE p.id="+id);
		
		Person person = (Person)query.uniqueResult();
		
		Set<CreditCard>creditCards = person.getCreditCards();
		
		session.delete(person);
         */
        Query query = openSession().createQuery("FROM User where id=" + id);
        User user = (User) query.uniqueResult();
        System.out.println(user.getLogin() + " : " + user.getPassword());
        if (null != user) {
            openSession().delete(user);
        }
    }

}
