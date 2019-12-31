<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="bookAdd" method="post">
		书名：<input type="text" name="bookName" /><br/>
		作者：<input type="text" name="author" /><br/>
		价格：<input type="text" name="price" /><br/>
		库存：<input type="text" name="stock" /><br/>
		销量：<input type="text" name="sales" /><br/>
		所在省份：<input type="text" name="address.province" /><br/>
		所在城市：<input type="text" name="address.city" /><br/>
		所在街道：<input type="text" name="address.street" /><br/>
		<input type="submit" value="添加图书" />
	</form>
</body>
</html>