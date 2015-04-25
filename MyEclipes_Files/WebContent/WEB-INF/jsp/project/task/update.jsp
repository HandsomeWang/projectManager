<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务更新</title>
</head>
<body>
<sf:form method="post" modelAttribute="task">
<table width="700" align="center" border="1">
	<tr>
	<td>任务序号:</td><td>${task.tnumber }<sf:hidden path="tid"/></td>
	</tr>
	<tr>
	<td>任务名称:</td><td><sf:input path="tname"/> <sf:errors path="tname"/> </td>
	</tr>
	<tr>
	<td>任务起始时间:</td><td><sf:input path="tyear"/>年<sf:input path="tmonth"/>月<sf:input path="tday"/>日
	<!-- <sf:errors path="tyear"/><sf:errors path="tmonth"/><sf:errors path="tday"/></td>
	 --></tr>
	<tr>
	<td>任务消耗时间:</td><td><sf:input path="tspend"/></td>
	</tr>
	<tr>
	<td>前置任务序号:</td><td><sf:input path="tafter"/></td>
	</tr>
	<tr>
	<td>前置任务类型:</td><td><sf:input path="ttype"/></td>
	</tr>
	<tr>

	<tr>
	<td colspan="2">
		<input type="submit" value="任务更新"/>
		<a href="<%=request.getContextPath() %>/project/task/tasklists">返回</a>
	</td>
	</tr>
</table>
</sf:form>
</body>
</html>