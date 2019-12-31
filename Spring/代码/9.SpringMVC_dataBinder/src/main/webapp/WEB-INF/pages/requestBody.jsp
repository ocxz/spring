<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		pageContext.setAttribute("ctp", request.getContextPath());
	%>

	<form action="${ctp }/testRequestBody" method="post"
		enctype="multipart/form-data">
		<input type="text" name="username" /><br /> <input type="password"
			name="pwd" /><br /> <input type="file" name="file" /><br /> <input
			type="submit" value="登陆">
	</form>
	<h2>
		<a href="${ctp }/testRequestBodyAjax">ajax发送json格式数据</a>
	</h2>
</body>
<script type="text/javascript" src="scripts/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$("a:first").click(function() {
		// js对象
		var emp = {
			lastName : "张三",
			email : "2252779530@qq.com",
			gender : 0
		};
		$.ajax({
			url : "${ctp }/testRequestBodyAjax",
			type : "POST",
			contentType : "application/json",
			data : JSON.stringify(emp),
			success : function(data) {
				alert(data);
			}
		});
		return false;
	});
</script>
</html>