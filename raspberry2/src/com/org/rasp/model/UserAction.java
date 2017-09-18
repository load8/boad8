package com.org.rasp.model;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户操作Action
 * @author dell
 *
 */
public class UserAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
   // private static Logger logger = Logger.getLogger(UserAction.class);
    //注入service到action层
    @Resource
    public UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private String id;
    private String userName;
    private String password;
    private String email;
    private int userId;

    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
     * 添加用户信息
     *
     * @return
     */
    public String addUser() {
        User user = new User();
        try {
            int iid =new Random().nextInt(100);
            user.setUserId(iid);
            user.setUserName(userName);
           // user.setPassword(password);
            user.setEmail(email);
            userService.addUser(user);
        } catch (Exception e) {
      //      logger.error("exception in add user", e);
        	e.printStackTrace();
            return "ERROR";
        }
        return "SUCCESS";
    }

    /**
     * 从数据库中获得所有的用户信息
     *
     * @return
     */
    public String queryUsers() {
        try {
            List<User> userList = userService.queryUsers();
            System.out.println(userList.size()+"----");
            for (int i = 0; i < userList.size(); i++) {
                System.out.println(userList.get(i).getUserId());
            }
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("list", userList);
            return "list";
        } catch (Exception e) {
     //       logger.error("Exception in queryUsers", e);
        	e.printStackTrace();
            return "ERROR";
        }
    }

    /**
     * 删除用户信息
     *
     * @return
     */
    public String delUser() {
        try {
        	System.out.println("---"+getUserId());
            userService.delUser(getUserId());
        } catch (Exception e) {
        //    logger.error("Exception in delUser", e);
         	e.printStackTrace();
            return "ERROR";
        }
        return "SUCCESS";
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
