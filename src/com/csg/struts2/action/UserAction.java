package com.csg.struts2.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.csg.struts2.pojo.User;
import com.csg.struts2.service.UserService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven {
	private User user = new User();
	//遇到对象中没有的属性，struts2会尝试在Action中寻找对应的属性并赋值 
	private Integer rows = 0;
	private Integer page = 0;

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
	
	public String getList() throws IOException{
		List<User> userList = userService.findAll();
		List<User> pageData = new ArrayList<User>();
		if(rows * page>userList.size()){
			pageData = userList.subList(rows*(page-1), userList.size());
		}else{
			pageData = userList.subList(rows*(page-1), rows*page);
		}
		
		Map hm = new HashMap();
		double totle= Math.ceil(new Double(userList.size())/new Double(rows));
		hm.put("totle", totle);
		hm.put("rows", pageData);
		hm.put("page", page);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(new Gson().toJson(hm));
		//如果需要向客户端输出响应，而不是页面跳转，使用return null
		return null;
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
	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	
}
