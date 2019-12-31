<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><fmt:message key="welcominfo"/></h1>
	<form action="">
		<fmt:message key="username" />:<input type="text" name="logName"><br/>
		<fmt:message key="password" />:<input type="password" name="logPwd"><br/>
		<input type="submit" value='<fmt:message key="loginBtn" />'>
	</form>
</body>
</html>