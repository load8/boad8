package com.org.rasp.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.org.rasp.model.User;
import com.org.rasp.service.UserService;

@Scope("prototype")//默认单例模型
@Namespace("/user")//命名空间
@Results({@Result(name="listview",location="/user/user!list.action",type = "redirect")})//两个action之间的传递，可以带参数，在type = "redirect"后面加，params=你的参数和�?
public class UserAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
	
	
	
	private List<User> users;
	private User user = new User();
	
	/**
	 * 进入列表
	 * @return
	 */
	public String list(){
		users = userService.getAllUser();
		return "list";
	}
	

	/**
	 * 注册
	 * @return 返回列表
	 */
	public String register(){
		user.setCreatDate(new Date());
		userService.addUser(user);
		return "listview";
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	public String delete(){
		userService.delUser(user.getUserId());
		return "listview";
	}
	
	/**
	 * 进入更新界面
	 * @return
	 */
	public String intoUpdate(){
		user = userService.getUser(user.getUserId());
		return "update";
	}
	
	/**
	 * 更新用户
	 * @return
	 */
	public String update(){
		user.setCreatDate(new Date());
		userService.updateUser(user);
		return "listview";
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}
