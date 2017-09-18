package com.org.rasp.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service 
public class UserServiceImpl implements UserService {
	// ע��UserDao��service��
	@Resource
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * ����û�
	 */
	public void addUser(User user) {
		userDao.addUser(user);
	}

	/**
	 * �г������û�
	 */
	public List<User> queryUsers() {
		List<User> userList = userDao.queryUsers();
		return userList;
	}

	/**
	 * ɾ���û�
	 */
	public void delUser(int id) {
		userDao.delUser(id);
	}

}
