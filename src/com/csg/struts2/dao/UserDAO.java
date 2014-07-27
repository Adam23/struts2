package com.csg.struts2.dao;

import java.util.List;

import com.csg.struts2.pojo.User;
import com.csg.struts2.util.DataSource;

public class UserDAO {
	public void insert(User u){
		DataSource.getUsers().add(u);
	}
	
	public List<User> findAll(){
		return DataSource.getUsers();
	}
}
