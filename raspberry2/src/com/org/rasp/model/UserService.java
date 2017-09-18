package com.org.rasp.model;

import java.util.List;

public interface UserService {
    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user);
    
    /**
     * 列出所有的用户
     * @return
     */
    public List<User> queryUsers();
    
    /**
     * 删除用户
     * @param id
     */
    public void delUser(int id);
}