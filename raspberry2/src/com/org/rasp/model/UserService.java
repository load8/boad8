package com.org.rasp.model;

import java.util.List;

public interface UserService {
    /**
     * ����û�
     * @param user
     */
    public void addUser(User user);
    
    /**
     * �г����е��û�
     * @return
     */
    public List<User> queryUsers();
    
    /**
     * ɾ���û�
     * @param id
     */
    public void delUser(int id);
}