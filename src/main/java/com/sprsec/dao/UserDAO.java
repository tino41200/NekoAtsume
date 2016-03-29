package com.sprsec.dao;

import java.util.List;

import com.sprsec.model.Chat;
import com.sprsec.model.User;

public interface UserDAO {

    public User getUser(String login);

    public User getUserById(int id);

    public void add(User user);

    public void edit(User user);

    public List<User> listeUser();

    public void deleteUser(int id);
}
