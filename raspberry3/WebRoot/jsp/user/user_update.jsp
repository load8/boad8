<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>更新</title>
	</head>
	<body>
		<form action="user!update.action" method = "post">
			<input type = "hidden" name = "user.userId" value = "<s:property value = "user.userId"/>">
			id:<s:property value = "user.userId"/><br>
			用户名：<input type = "text" name = "user.name" value = "<s:property value = "user.name"/>"/><br>
			邮    箱：<input type = "password" name = "user.email" value = "<s:property value = "user.email"/>"/><br>
			年    龄：<input type = "text" name = "user.age" value = "<s:property value = "user.age"/>"/><br>
			
			<input type = "submit" value="修 改">
		</form>
	</body>
</html>