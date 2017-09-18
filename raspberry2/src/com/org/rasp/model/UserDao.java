package com.org.rasp.model;


import java.util.List;



public interface UserDao {
    /**
     * ����û�
     * @param user
     */
    public void addUser(User user);
    
    /**
     * �г������û�
     * @return
     */
    public List<User> queryUsers();
    
    /**
     * ɾ���û�
     * @param id
     */
    public void delUser(int id);
}