package com.csg.struts2.action;

import com.csg.struts2.pojo.User;
import com.csg.struts2.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven {
	private User user = new User();
	private UserService userService = new UserService();
	public String  execute() {
		System.out.println("执行了execute()方法");
		return "success";
	}
	
	public String register(){
		userService.registerUser(user);
		System.out.println("Register()");
		return this.SUCCESS;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Object getModel() {
		return user;
	}
	
}
