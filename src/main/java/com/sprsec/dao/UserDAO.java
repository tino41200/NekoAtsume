package com.sprsec.dao;

import com.sprsec.model.User;

public interface UserDAO {
	public User getUser(String login);
	public User getUserById(int id);
	public void add(User user);
	public void edit(User user);
}
