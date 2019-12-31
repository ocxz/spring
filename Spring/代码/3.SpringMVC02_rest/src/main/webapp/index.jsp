<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		<a href="book/1">查询1号图书</a>
	</h3>
	
	<form action="book/1" method="post">
		<input type="hidden" name="_method" value="put" /><br/> 
		<input type="submit" value="修改1号图书" />
	</form>
	
	<form action="book/1" method="post">
		<input type="hidden" name="_method" value="delete"><br/> 
		<input type="submit" value="删除1号图书" />
	</form>
	
	<form action="book" method="post">
		<input type="submit" value="添加图书">
	</form>
</body>
</html>