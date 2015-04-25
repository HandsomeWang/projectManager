<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建资源</title>
</head>
<body>
<sf:form method="post" modelAttribute="res">
<table width="700" align="center" border="1">
	<tr>
	<td>资源名称:</td><td><sf:input path="rname"/><sf:errors path="rname"/></td>
	</tr>
	<tr>
	<td>资源消耗/天:</td><td><sf:input path="rmoney"/></td>
	</tr>
	<tr>
	<td colspan="2">
		<input type="submit" value="确定新建"/>
		<a href="<%=request.getContextPath() %>/project/res/reslists">返回</a>
	</td>
	</tr>
</table>
</sf:form>
</body>
</html>