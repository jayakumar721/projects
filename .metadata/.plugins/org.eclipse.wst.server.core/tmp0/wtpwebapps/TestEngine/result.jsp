<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.result{
text-align:center;
margin-top:50px;
height:400px;
width:300px;
border:1px solid #ccffcc;
background-color:#eee;
}
.content{
margin-top:150px;
}

</style>

</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="col-sm-2"></div>
	<div class="result col-sm-8">
	<div class="col-sm-4"></div>
	<div class="content col-sm-4">
		<label>Your Score is:<%=session.getAttribute("marks") %></label><br>
		<%
		if((int)session.getAttribute("marks")>4){
		%>
		<label style="color:green">Your eligible</label>
		<% 
		}else{
		
		%>
		<label style="color:red">Your not eligible</label>
		<%
		}
		%>
	</div>
	</div>
</body>
</html>