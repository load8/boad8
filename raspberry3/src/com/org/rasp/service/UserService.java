package com.org.rasp.service;

import java.util.List;

import com.org.rasp.model.User;

public interface UserService {

    public User getUser(int id);

    public List<User> getAllUser();

    public void addUser(User user);

    public boolean delUser(int id);

    public boolean updateUser(User user);
}