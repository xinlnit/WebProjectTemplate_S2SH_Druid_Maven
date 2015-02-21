<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="CENTER">
		<h2>页面出错了~</h2>
		<hr>
		<font color="red">出现异常：<br> <s:property
				value="exception.message" /><br> <s:property
				value="exception.stackTrace" /><br> 简单的打印异常信息:<s:property
				value="exception" /><br> 打印异常的堆栈信息<s:property
				value="exceptionStack" />
		</font><br> <a href="javascript:void(0);"
			onclick="window.history.back();">返回</a>
	</div>
</body>
</html>