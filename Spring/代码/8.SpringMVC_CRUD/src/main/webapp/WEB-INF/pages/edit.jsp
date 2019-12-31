<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工信息修改</title>
<% pageContext.setAttribute("ctp", request.getContextPath()); %>
</head>
<body>
	<h2>员工信息修改</h2>
	<form:form action="${ctp }/emp/${employee.uid }"
	 modelAttribute="employee" method="post">
	 	<input type="hidden" name="_method" value="put">
	 	<input type="hidden" name="uid" value="${employee.uid }">
	 	<input type="hidden" name="lastName" value="${employee.lastName }">
		<h4>员工编号：${employee.uid }</h4>
		<h4>员工姓名：${employee.lastName }</h4>
		员工性别：
			<form:radiobutton path="gender" value="1" label="男"/>
			<form:radiobutton path="gender" value="0" label="女"/><br/>
		员工邮箱：<form:input path="email"/><br/>
		所在部门：
			<form:select path="department.did" items="${depts }" 
				itemLabel="departmentName" itemValue="did"></form:select><br/>
		<input type="submit" value="提交修改">
	</form:form>
</body>
</html>