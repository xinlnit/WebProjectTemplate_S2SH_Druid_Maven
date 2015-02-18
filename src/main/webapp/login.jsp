<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <form method="post" id="myForm" action="login.action">
   		
	    <center>
	    <table><tr><td bgcolor=#CCCCCC>登录(login.action)</td></tr></table>
		<table>
			<tr>
				<td>账号/手机：</td>
				<td><input type="text" value="admin" name="account">(account)</td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td><input type="text" value="admin" name="password">(password)</td>
			</tr>
		</table>
		<input type="submit" value="提交">
	    </center>
    </form>
  </body>
</html>
