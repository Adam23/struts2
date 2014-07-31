package com.csg.struts2.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Security extends AbstractInterceptor{
	private String exclude;
	private List<String> excludeList = new ArrayList();
	
	public String intercept(ActionInvocation invocation) throws Exception {
		String uri = ServletActionContext.getRequest().getRequestURI();
		String context = ServletActionContext.getServletContext().getContextPath();
		
		for(String ex : excludeList){
			String fullPath = context + ex;
			System.out.println(fullPath);
			System.out.println(uri);
			if(fullPath.equalsIgnoreCase(uri)){
				String result = invocation.invoke();
				System.out.println("Result:" + result);
				return result;
			}
		}
		
		String username = (String)ServletActionContext.getRequest().getSession().getAttribute("loginuser");
		if(username == null){
			ServletActionContext.getRequest().getSession().setAttribute("errMsg", "用户未登录或回话超时，请重新登录");
			return "login";
		}else{
			ServletActionContext.getRequest().getSession().removeAttribute("errMsg");	
			return invocation.invoke();
		}
	}
	
	public void init() {
		System.out.println("。。。。SecurityInterceptor");
	}

	public String getExclude() {
		return exclude;
	}


	public void setExclude(String exclude) {
		this.exclude = exclude;
		String[] exs = exclude.split(",");
		for(String ex : exs){
			excludeList.add(ex);
		}
	}
}
