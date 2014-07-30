package com.csg.struts2.interceptor;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Security extends AbstractInterceptor{
	private String exclude;
	private List<String> excludeList = new ArrayList();
	
	public String intercept(ActionInvocation invocation) throws Exception {
		String uri = ServletActionContext.getRequest().getRequestURI();
		String context = ServletActionContext.getServletContext().getContextPath();
		
		for(String exl:excludeList){
			String fullPath = context + exl;
			if(fullPath.equalsIgnoreCase(uri)){
				String result = invocation.invoke();
				System.out.println("result:"+result);
				return result;
			}
		}
		
		String name = (String) ServletActionContext.getRequest().getSession().getAttribute("loginuser");
		if(name == null){
			ServletActionContext.getRequest().getSession().setAttribute("errMsg", "您未登录或登录超时，请重新登录");
			return "login";
		}else{
			return invocation.invoke();
		}
		
	}

	public String getExclude() {
		return exclude;
	}

	public void setExclude(String exclude) {
		this.exclude = exclude;
		String[] list = exclude.split(",");
		for(String li:list){
			excludeList.add(li);
		}
	}

	@Override
	public void init() {
		System.out.println("在准备Security……");
	}
}
