<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加员工2</title>
<style type="text/css">
	.error{
		color: red;
	}
</style>
</head>
<body>

	<form:form action="${ctp }/emp" modelAttribute="employee">
		员工编号： <b>${employee.uid }</b>
			   <input type="hidden" name="uid" value="${employee.uid }">
		       <span class="error">${errorInfo.uid }</span>
		       <br />
		员工姓名： <form:input path="lastName" />
			   <span class="error">${errorInfo.lastName }</span>
		       <br />
		员工性别：
			   <form:radiobutton path="gender" value="1" label="男" />
		       <form:radiobutton path="gender" value="0" label="女" />
		       <br />
		员工邮箱：<form:input path="email" />
			   <span class="error">${errorInfo.email }</span>
			   <form:errors path="email" cssClass="error"></form:errors>
		       <br />
		出生日期：<form:input path="birthday" />
		       <span class="error">${errorInfo.birthday }</span>
		       <form:errors path="birthday" cssClass="error"></form:errors>
		       <br />
		员工部门：<form:select path="department.did" items="${deps }"
			      itemLabel="departmentName" itemValue="did"></form:select>
		       <br />
		       <input type="submit" value="添加">
	</form:form>
	<form action="${ctp }/quickadd">
		<!-- 快速添加，将员工的所有信息都写上，自动封装对象 -->
		<input name="empinfo" value="王五&1&wangwu@qq.com&p-001" /> <input
			type="submit" value="快速添加">
	</form>
</body>
</html>