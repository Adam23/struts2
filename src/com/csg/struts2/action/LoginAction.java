package com.csg.struts2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		if(username.equals("admin")&&password.equals("123456")){
			request.getSession().setAttribute("loginuser", username);
			return this.SUCCESS;
		}else{
			request.getSession().setAttribute("errMsg", "还未登录");
			request.getSession().removeAttribute("loginuser");
			return this.INPUT;
		}
	}
	public String toLogin(){
		return this.SUCCESS;
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
