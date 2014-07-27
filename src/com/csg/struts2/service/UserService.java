package com.csg.struts2.service;

import java.util.List;

import com.csg.struts2.dao.UserDAO;
import com.csg.struts2.pojo.User;

public class UserService {
	UserDAO userDAO = new UserDAO();
	public void registerUser(User u){
		userDAO.insert(u);
	}
	
	public List<User> findAll(){
		return userDAO.findAll();
	}

}
