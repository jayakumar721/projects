<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>dashboard</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="vendor/jquery-validation/dist/jquery.validate.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.navbar-inverse {
	background: #00796B;
	border-bottom-color: #004D40;
}

.navbar-inverse .navbar-nav>li>a, .navbar-inverse .navbar-brand,
	.navbar-inverse .navbar-nav>.dropdown>a .caret {
	color: #fff;
}

.navbar-inverse .navbar-nav>.open>a, .navbar-inverse .navbar-nav>.open>a:hover,
	.navbar-inverse .navbar-nav>.open>a:focus, .navbar-nav>li>.dropdown-menu
	{
	background: #4DB6AC;
}

.nav-pills
>
li
>
a
,
{
color








:




 




#303F9F








;
}
.nav>li>a:hover, .nav>li>a:focus {
	background-color: #EEEEEE;
}

.right {
	height: 500px;
	border: 1px solid #EEEEEE;
}
</style>
</head>
<body>
<%if(session.getAttribute("name")!=null){ %>
	<div>
		<%@ include file="header.jsp"%>
	</div>
	<div class="col-sm-2"></div>
	<div class="right col-sm-8">
		<div style="width: 100%; height: 20px; color: blue; margin-top: 10px">
			Welcome,
			<%=session.getAttribute("name")%></div>
			<div class="col-sm-2"></div>
		<div class="col-sm-6" style="font-family:timesnewroman;font-size:20px;font-style:italic;width: 100%; height: 300px; color: red; margin-top: 50px">
			<ol type="1">
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ol>
			<div style="float:right;color:green;">
				All the best,<a href="Questions" id="taketest">Take Test</a>
			</div>
		</div>
	</div>
<%} else {
  response.sendRedirect("Login.html");
}%>


</body>
</html>