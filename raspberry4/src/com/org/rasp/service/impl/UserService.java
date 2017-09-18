package com.org.rasp.service.impl;

import java.util.List;

import com.org.rasp.entity.User;

public interface UserService {

    public User getUser(int id);

    public List<User> getAllUser();

    public void addUser(User user);

    public boolean delUser(int id);

    public boolean updateUser(User user);
}