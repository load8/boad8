package com.org.rasp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.rasp.dao.UserDao;
import com.org.rasp.model.User;

//×¢ÈëService
@Service
public class UserServiceImpl implements UserService {
    //×¢ÈëDao
    @Resource
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