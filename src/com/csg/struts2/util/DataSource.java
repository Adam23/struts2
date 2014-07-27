package com.csg.struts2.util;

import java.util.ArrayList;
import java.util.List;

import com.csg.struts2.pojo.User;

public class DataSource {
	private static List users = new ArrayList();
	public static List<User> getUsers(){
		return users;
	}
}
