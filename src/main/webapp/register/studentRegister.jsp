<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生注册页面(单向管理)</title>
</head>
<body>
<form method="post"  action="<%=basePath %>studentRegister.action">
	    <center>
	    <table><tr><td bgcolor=#CCCCCC>学生员注册(studentRegister.action)</td></tr></table>
		<table>
			<tr>
				<td>账号：</td>
				<td><input type="text" value="student" name="student.accountManage.account">(account)</td>
			</tr>
			<tr>
				<td align="right">名字：</td>
				<td><input type="text" value="oneStudent" name="student.name">(name)</td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td><input type="text" value="student" name="student.accountManage.password">(password)</td>
			</tr>
		</table>
		<input type="submit" value="提交">
	    </center>
</body>
</html>