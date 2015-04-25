<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务[${task.tname }]的详细信息</title>
</head>
<body>
<table width="700" align="center" border="1">
	<tr>
	<td>任务序号:</td><td>${task.tnumber }</td>
	</tr>
	<tr>
	<td>任务名称:</td><td>${task.tname }</td>
	</tr>
	<tr>
	<td>任务起始时间:</td><td>${task.tyear }年${task.tmonth}月${task.tday}日</tr>
	<tr>
	<td>任务消耗时间:</td><td>${task.tspend}天</td>
	</tr>
	<tr>
	<td>前置任务序号:</td><td>${task.tafter}</td>
	</tr>
	<tr>
	<td>前置任务类型:</td><td>${task.ttype}</td>
	</tr>
	<tr>
	<td>资源分配情况:</td><td>${resnames}</td>
	</tr>
	<tr>
	<tr>
	<td colspan="7">
			<a href="<%=request.getContextPath() %>/project/task/tasklists">返回</a>
			<a href="<%=request.getContextPath() %>/project/task/${task.tid }/update">更新</a>
			<a href="<%=request.getContextPath() %>/project/task/${task.tid }/delete">删除</a>
		</td>
	</tr>
</table>
</body>
</html>