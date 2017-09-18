package com.org.rasp.dao;

import java.util.List;

import com.org.rasp.entity.User;

public interface UserDao {

    public User getUser(int id);

    public List<User> getAllUser();

    public void addUser(User user);

    public boolean delUser(int userId);

    public boolean updateUser(User user);
}