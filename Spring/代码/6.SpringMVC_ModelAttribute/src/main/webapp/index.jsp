<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="hello">修改图书-不能改变书名</a></h1>
	
	<form action="book" method="post">
		<input type="hidden" name="_method" value="put" />
		<input type="hidden" name="bookId" value="100" />
		书名：西游记<br/>
		作者：<input type="text" name="author" /><br/>
		价格：<input type="text" name="price" /><br/>
		库存：<input type="text" name="stock" /><br/>
		销量：<input type="text" name="sales" /><br/>
		<input type="submit" value="修改图书" />
	</form>
</body> 
</html>