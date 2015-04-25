<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全部项目</title>
</head>
<body>
<table width="700" align="center" border="1">
	<tr>
	<td>项目编号</td><td>项目名称</td><td>项目起始时间</td><td>项目消耗时间</td>
	<td>操作</td>
	</tr>
	<c:if test="${pagers.total le 0 }">
		<tr>
		<td colspan="5">目前还没有项目数据</td>
		</tr>
	</c:if>
	<c:if test="${pagers.total gt 0}">
		<c:forEach items="${pagers.datas }" var="p">
		<tr>
		<td>${p.pid }</td>
		<td><a href="${p.pid }">${p.pname }</a></td>
		<td>${p.pdate }</td>
		<td>${p.pspend }天</td>
		<td><a href="${p.pid }/update">更新</a>&nbsp;<a href="${p.pid }/delete">删除</a></td>
		</tr>
		</c:forEach>
		<tr>
		<td colspan="5">
			<jsp:include page="/inc/pager.jsp">
				<jsp:param value="projects" name="url"/>
				<jsp:param value="${pagers.total}" name="items"/>
			</jsp:include>
		</td>
		</tr>	
	</c:if>
</table>
</body>
</html>