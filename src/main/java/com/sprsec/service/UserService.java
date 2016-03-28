package com.sprsec.service;

import com.sprsec.model.User;

public interface UserService {
	public User getUser(String login);
	public User getUserById(int id);
	public void addUser(User user);
	public void editUser(User user);
	void updateUser(User user);
}
