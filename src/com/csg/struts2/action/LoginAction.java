package com.csg.struts2.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	
	public String toLogin(){
		return this.SUCCESS;
	}
	
	public String login() throws IOException{
		System.out.println("1111111111");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		System.out.println("user="+username);
		System.out.println("pass="+password);
		
		if(username.equals("admin") && password.equals("123")){
			request.getSession().setAttribute("loginuser", username);
			return this.SUCCESS;
		}else{
			request.getSession().removeAttribute("loginuser");
			request.getSession().setAttribute("errMsg", "用户名或密码错误");
			return this.INPUT;
		}
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
