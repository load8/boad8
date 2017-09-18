package com.org.rasp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.org.rasp.dao.UserDao;
import com.org.rasp.entity.User;

@SuppressWarnings("unchecked")
//注入
@Repository
public class UserDaoImpl implements UserDao {

    //注入已在spring-common.xml中配制好的sessionFactory
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public User getUser(int id) {
        String hql = "from User u where u.userId=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0, id);
        return (User) query.uniqueResult();
    }


	@Override
    public List<User> getAllUser() {
        String hql = "from User";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public void addUser(User user) {
/*    	Session session =  sessionFactory.getCurrentSession();
    	session.beginTransaction();
    	user.setUserId(7);
    	session.save(user);
    	session.getTransaction().commit(); */
    	System.out.println(user.getUserId());
    	System.out.println(user.getName());
    	System.out.println(user.getEmail());
 
    	
        int i = (Integer) sessionFactory.getCurrentSession().save(user);
        System.out.println(i);
    }

    @Override
    public boolean delUser(int userId) {
        String hql = "delete User u where u.userId = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0, userId);
        return (query.executeUpdate() > 0);
    }

    @Override
    public boolean updateUser(User user) {
        String hql = "update User u set u.name = ?,u.age=? where u.userId = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, user.getName());
        query.setString(1, user.getAge());
        query.setInteger(2, user.getUserId());
        return (query.executeUpdate() > 0);
    }
}