<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员注册页面</title>
</head>
<body>
<form method="post"  action="adminRegister.action">
	    <center>
	    <table><tr><td bgcolor=#CCCCCC>管理员注册(adminRegister.action)</td></tr></table>
		<table>
			<tr>
				<td>账号：</td>
				<td><input type="text" value="admin" name="admin.account">(account)</td>
			</tr>
			<tr>
				<td align="right">名字：</td>
				<td><input type="text" value="oneAdmin" name="admin.name">(name)</td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td><input type="text" value="admin" name="admin.password">(password)</td>
			</tr>
		</table>
		<input type="submit" value="提交">
	    </center>
</body>
</html>