<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% pageContext.setAttribute("ctp", request.getContextPath()); %>
		<h3>${msg }</h3>
		<form action="fileUpload" method="post" enctype="multipart/form-data">
			头像：<input type="file" name="himage"> <br/>
			账号：<input type="text" name="username"> <br/>
			<input type="submit" value="登陆">
		</form>
		<hr/>
			
		<form action="fileUploads" method="post" enctype="multipart/form-data">
		账号：<input type="text" name="username"> <br/>
		头像1：<input type="file" name="files"> <br/>
		头像2：<input type="file" name="files"> <br/>
		文件1：<input type="file" name="file1"> <br/>
		文件2：<input type="file" name="file2"> <br/>
		<input type="submit" value="提交">
	</form>
	
	<h2><a href="fileDownLoad">点击下载</a></h2>
</body>
</html>