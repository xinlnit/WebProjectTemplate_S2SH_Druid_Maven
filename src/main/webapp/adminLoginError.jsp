<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!-- 使用jstl标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="CENTER">
		<h2>管理员登陆出错</h2>
		<hr>
		<font color="red">出现异常：<br> 
			 简单的异常信息:${exception }<br> 
			 异常的堆栈信息:
			<c:forEach var="msg" items="${exceptionStack }">
				  <c:out value="${msg}" />
			</c:forEach>
			
		</font><br>
		<a href="javascript:void(0);" onclick="window.history.back();">返回</a>
	</div>
</body>
</html>