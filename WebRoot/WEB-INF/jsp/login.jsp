<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>

  </head>
  
  <body>
  ${errMsg}<br/>
    <form action="login.action" method="post">
    	<span>用户名</span><input name="username" type="text">
    	<span>密码</span><input name="password" type="password">
    	<input type="submit" value="登录">
    </form>
  </body>
</html>
