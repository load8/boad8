package com.org.rasp.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service 
public class UserServiceImpl implements UserService {
	// 注入UserDao到service层
	@Resource
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 添加用户
	 */
	public void addUser(User user) {
		userDao.addUser(user);
	}

	/**
	 * 列出所有用户
	 */
	public List<User> queryUsers() {
		List<User> userList = userDao.queryUsers();
		return userList;
	}

	/**
	 * 删除用户
	 */
	public void delUser(int id) {
		userDao.delUser(id);
	}

}
