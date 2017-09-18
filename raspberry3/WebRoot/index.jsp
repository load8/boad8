<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>注册</title>
	</head>
	<body>
		<form action="user/user!register.action" method = "post">
			用户名：<input type = "text" name = "user.name"/><br>
			邮    箱：<input type = "text" name = "user.email"/><br>
			年    龄：<input type = "text" name = "user.age"/><br>
			
			<input type = "submit" value = "注 册">
		</form>
		<br><br>
		<a href = "<%=basePath%>user/user!list.action">进入用户列表</a>
	</body>
</html>