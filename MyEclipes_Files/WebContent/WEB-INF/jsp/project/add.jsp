<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建项目</title>
</head>
<body>
<sf:form method="post" modelAttribute="project">
<table width="700" align="center" border="1">
	<tr>
	<td>项目名称:</td><td><sf:input path="pname"/><sf:errors path="pname"/></td>
	</tr>
	<tr>
	<td>项目起始时间:</td><td><sf:input path="pdate"/><sf:errors path="pdate"/></td>
	</tr>
	<tr>
	<td>项目消耗时间:</td><td><sf:input path="pspend"/></td>
	</tr>
	<tr>
	<td colspan="2">
		<input type="submit" value="确定新建"/>
	</td>
	</tr>
</table>
</sf:form>
</body>
</html>