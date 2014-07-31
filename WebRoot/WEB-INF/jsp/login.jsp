<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
  </head>
  
  <body>
  ${errMsg}<br/>
	<form name = "login" method = "post" action = "login.action"> 
		用户名：<input name = "username" type="text"/>
		密码：<input name = "password" type = "password"/>
		<input type="submit" value = "登录"/>
	</form>
  </body>
</html>
