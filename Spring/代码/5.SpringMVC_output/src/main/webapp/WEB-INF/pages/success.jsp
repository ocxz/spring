<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>成功！！！</h1>
	<h1>pageScope：${pageScope.msg }</h1>
	<h1>requestScope：${requestScope.msg }</h1>
	<h1>sessionScope：${sessionScope.msg }--sessionScope：${sessionScope.msg1 }</h1>
	<h1>applicationScope：${applicationScope.msg }</h1>
</body>
</html>