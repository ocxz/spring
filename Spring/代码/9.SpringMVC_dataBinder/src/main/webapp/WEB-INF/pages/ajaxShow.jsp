<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>当前时间：<%=new Date() %></h2>
	<% pageContext.setAttribute("ctp", request.getContextPath()); %>
	<h3><a href="${ctp }/ajaxGetAllEmp">点击，ajax查询所有</a></h3>
	<div></div>
</body>
<script type="text/javascript" src="scripts/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$("a:first").click(function(){
		$.ajax({
			url:"${ctp }/ajaxGetAllEmp",
			type:"GET",
			success:function(data){
				console.log(data);
				$.each(data, function(){
					var empInfo = this.lastName + "-->" + this.birthday
						+ "-->" + this.gender;					
					$("div").append(empInfo + "<br/>");
				});
			}
		});
		return false;
	});
</script>
</html>