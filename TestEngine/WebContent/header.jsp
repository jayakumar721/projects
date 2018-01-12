<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
</style>


</head>
<body>
	<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="dashboard.jsp">CompanyName</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><i class="fa fa-user-circle"></i><a><%=session.getAttribute("name")%></a>

					</li>
					
					<li><a href="Logout.jsp"><i class="fa fa-sign-out"></i>
							Logout</a></li>
				</ul>
			</div>
		</div>
		<!-- /container -->
	</div>

</body>
</html>