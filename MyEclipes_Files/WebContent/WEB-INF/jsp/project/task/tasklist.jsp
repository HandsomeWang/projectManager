<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务列表</title>
</head>
<body>
<table width="900" align="center" border="1">
	
	<tr>
	<td>任务序号:</td>
	<td>任务名称</td>
	<td>任务开始时间</td>
	<td>任务消耗时间</td>
	<td>前置任务</td>
	<td>操作</td>
	</tr>
	<c:if test="${pagers.total le 0 }">
		<tr>
		<td colspan="6">目前还没有项目数据</td>
		</tr>
	</c:if>
	<c:if test="${pagers.total gt 0}">
		<c:forEach items="${pagers.datas }" var="t">
		<tr>
		<td>${t.tnumber }</td>
		<td><a href="${t.tid }">${t.tname }</a></td>
		<td>${t.tyear }年${t.tmonth }月${t.tday }日</td>
		<td>${t.tspend }天</td>
		<td>${t.tafter }${t.ttype }</td>
		<td><a href="${t.tid }/update">更新</a>&nbsp;&nbsp;&nbsp;
			<a href="${t.tid }/disres">分配资源</a>&nbsp;&nbsp;&nbsp;
			<a href="${t.tid }/delete">删除</a></td>
		</tr>
		</c:forEach>
		<tr>
		<td colspan="6">
			<jsp:include page="/inc/pager.jsp">
				<jsp:param value="projects" name="url"/>
				<jsp:param value="${pagers.total}" name="items"/>
			</jsp:include>
		</td>
		</tr>	
	</c:if>
	<tr>
	<td colspan="6">
			<a href="<%=request.getContextPath() %>/project/task/add">添加新任务</a>
		</td>
	</tr>
</table>
</body>
</html>