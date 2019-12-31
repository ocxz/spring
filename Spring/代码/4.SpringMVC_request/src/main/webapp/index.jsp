<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="hello">hello</a></h1>
	<h1><a href="handle01?userName=cxz">handle01请求</a></h1>
	<h1><a href="handle02">handle02请求</a></h1>
	
	<form action="handle01" method="post">
		<input type="text" name="userName" />
		<input type="submit" value="提交">
	</form>
	<hr/>
	<h1><a href="book">点击添加图书</a></h1>
</body>
</html>