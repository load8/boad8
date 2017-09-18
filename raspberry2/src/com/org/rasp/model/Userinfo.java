package com.org.rasp.model;

import java.util.Date;

public class Userinfo {
	private int userId;
	private String userName;
	private String email;
	private String sex;
	private int age;
	private Date creatDate;
	private Date modifyDate;

	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Userinfo(int userId, String userName, String email, String sex,
			int age, Date creatDate, Date modifyDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.sex = sex;
		this.age = age;
		this.creatDate = creatDate;
		this.modifyDate = modifyDate;
	}

	
}
