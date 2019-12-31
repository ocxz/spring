<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加员工</title>
</head>
<body>
	<h2>添加员工</h2>
	<form action="emp" method="post">
		员工编号：<h4>${uid }</h4>
		<input hidden="hidden" name="uid" value="${uid }"><br/>
		员工姓名：<input type="text" name="lastName"><br/>
		员工性别：
			男：<input type="radio" name="gender" value="1" checked="checked">
			女：<input type="radio" name="gender" value="0"><br/>
		员工邮箱：<input type="text" name="email"><br/>
		员工部门：
			<select name="department.did">
				<c:forEach items="${deps }" var="dep">
					<option value="${dep.did }">${dep.departmentName }</option>
				</c:forEach>
			</select><br/>
			<input type="submit" value="添加">
	</form>
</body>
</html>