package com.org.rasp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.rasp.dao.UserDao;
import com.org.rasp.entity.User;
import com.org.rasp.service.UserService;

//×¢ÈëService
@Service
public class UserServiceImpl implements UserService {
    //×¢ÈëDao
    @Autowired
    private UserDao userDao;

/*    @Autowired
    private CustomerDao customerDao;*/

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public boolean delUser(int userId) {
        return userDao.delUser(userId);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }
}