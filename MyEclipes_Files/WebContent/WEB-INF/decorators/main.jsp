<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title default="欢迎使用项目管理系统"/></title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css"/>
<decorator:head/>
</head>
<body>
<h1><decorator:title/></h1>
<c:if test="${not empty loginUser}">
<a href="<%=request.getContextPath() %>/project/add">新建项目</a>
<a href="<%=request.getContextPath() %>/project/projects">项目列表</a>
<a href="<%=request.getContextPath() %>/project/res/reslists">资源列表</a>
<a href="<%=request.getContextPath() %>/logout">退出系统</a>
 当前用户:${loginUser.uname }
</c:if> 
<hr/>
<decorator:body/>
</body>
</html>