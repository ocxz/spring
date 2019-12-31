<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工详情</title>
</head>
<% pageContext.setAttribute("ctp", request.getContextPath()); %>
<body>
	<h2>员工信息</h2>
	<h3>员工编号：${emp.uid}</h3>
	<h3>员工姓名：${emp.lastName}</h3>
	<h3>员工性别：${emp.gender==0?"女":"男"}</h3>
	<h3>员工邮箱：${emp.email}</h3>
	<hr/>
	<h2>部门信息</h2>
	<h3>部门编号：${emp.department.did}</h3>
	<h3>部门名称：${emp.department.departmentName}</h3>
	<h3><a href="${ctp }">返回首页</a></h3>
</body>
</html>