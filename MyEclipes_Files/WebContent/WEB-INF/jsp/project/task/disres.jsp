<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分配资源</title>
</head>
<body>
<form method="post">
<table width="700" align="center" border="1">
	<tr>
	<td>任务名称:</td><td>${tname }</td>
	</tr>
	<tr>
	<td>分配资源:</td>
	<td>
	<c:forEach items="${listRes }" var="l">
		<input type="checkbox" name="myres" id="myres" value="${l.rid }"/>${l.rname }
	</c:forEach>

	</td>
	</tr>

	<tr>
	<td colspan="2">
		<input type="submit" value="确认分配"/>
		<a href="<%=request.getContextPath() %>/project/task/tasklists">返回</a>
	</td>
	</tr>
</table>
</form>
</body>
</html>