<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title> 用户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style>
			.link,.link_span {
				color: blue;
				cursor: hand;
				text-decoration: underline;
			}
       </style>
  </head>
  
  <body>
   用户列表
   <s:if test="users!=null">
	<table width="96%"  align="center" class="newGrid" cellspacing="0" cellpadding="0" id="grid">
		<thead><tr>
		<th width="16%"><Strong>id</Strong></th>
		<th width="20%"><Strong>用户名</Strong></th>
		<th width="20%"><Strong>邮    箱</Strong></th>
		<th width="20%"><Strong>年    龄</Strong></th>

		
		<th width="12%"><Strong>修改</Strong></th>
		<th width="12%"><Strong>删除</Strong></th>
		</tr></thead>
		<s:iterator value="users" status="stat">
			<tr align="center"  height="21px">
				<td width="16%">&nbsp;
				  <s:property value="id"></s:property></td>
				<td width="20%">&nbsp;
				  <s:property value="name"></s:property></td>
				<td width="20%">&nbsp;
					<s:property value="email"></s:property>
				</td>
				<td width="20%">&nbsp;
				  <s:property value="age"></s:property></td>

				<td width="12%">
					<span class="link" title="修改"
								onclick="modify('<s:property value="user.userId"/>');">
								修改 </span>
				</td>
				
				<td width="12%">
					<span class="link" title="删除"
								onclick="remove('<s:property value="user.userId"/>');">
								删 除 </span>
				</td>
			</tr>
		</s:iterator>
	</table>

</s:if>
	<a href = "<%=basePath%>">继续注册</a>
  </body>
  <script type="text/javascript">
  	function remove(id) 
    {
      if(confirm("真的要删除该用户吗？"))
         location.href="<%=basePath%>/user/user!delete.action?user.userId="+id;         
    }
    function modify(id) 
    {
         location.href="<%=basePath%>/user/user!intoUpdate.action?user.userId="+id;         
    }
  </script>
  
</html>
