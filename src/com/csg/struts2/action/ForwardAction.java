package com.csg.struts2.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ForwardAction extends ActionSupport{
	private String target;
	public String forward(){
		String uri = ServletActionContext.getRequest().getRequestURI();
		System.out.println(uri);
		String page = uri.substring(uri.indexOf("_") + 1 , uri.lastIndexOf("."));	
		page = "/" + page.replace("_jsp", ".jsp").replace("_htm", ".htm").replace("_", "/");
		System.out.println(page);
		this.target = page;
		return this.SUCCESS;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
}