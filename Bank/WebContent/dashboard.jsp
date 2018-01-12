<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Dashboard</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
margin-top: 10%;
}
.pull-right {
	float: right;
	padding-right:15px
}
/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	position: absolute;
	width: 100%;
	bottom: 0;
	padding: 15px;
	bottom: 0;
}

ul {
	padding: 0;
	list-style: none;
}

ul li {
	display: inline-block;
	position: relative;
	line-height: 21px;
	text-align: left;
}

ul li a {
	display: block;
	padding: 8px 25px;
	color: #333;
	text-decoration: none;
}

ul li a:hover {
	color: blue;
}

ul li ul.dropdown {
	min-width: 200px; /* Set width of the dropdown */
	display: none;
	position: absolute;
	background-color: #f1f1f1; z-index : 999;
	left: 0;
	z-index: 999;
}

ul li:hover ul.dropdown {
	display: inline-block; /* Display the dropdown */
}

ul li ul.dropdown li {
	display: block;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: 100%;
		padding: 15px;
	}
	.row.content {
		height: 100%;
	}
}
</style>
</head>
<body>


	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="dashboard.jsp">Logo</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Balance</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">profile</a>
						<ul class="dropdown">
							<li><a class="load">Change Password</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li style="padding-top: 15px; padding-bottom: 15px; color: #9d9d9d">Welcome,<%=session.getAttribute("emailId")%></li>
					<li><a href="login.html"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					<li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid text-center">
			<div class="row content" id="change"></div>
			</div>

			
	

	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>
	<script>
		$(document).ready(function(){
			$('.load').click(function(){
				$('#change').load("passwordChange.html");
			});
		});	
	</script>
</body>
</html>
