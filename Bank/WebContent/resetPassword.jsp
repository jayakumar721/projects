<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.input-head {
	/*	font-size:13px;*/
	font-weight: none;
	font-family: times;
}

.form_bg {
	color: #666;
	padding: 20px;
	border-radius: 10px;
	border: 1px solid grey;
	margin: auto;
	margin-top: 70px;
	width: 290px;
	height: 370px;
}

header {
	text-align: center;
}

body {
	background-color: #f3ffe6;
}
.pull-right {
	float: right;
	padding-right:15px
}
.btn {
	margin-left: 35%;
}

footer {
	position: absolute;
	bottom: 0;
	width: 100%;
}
</style>
</head>
<body>
	<header>
		<h1>MyBank</h1>
	</header>
	<div class="container">
		<form action="ResetPasswordServlet" method="post">
			<div class="form_bg">
				<div>
					<div class="from-group">
						<label class="input-head">Email Id</label>
						<div style="margin-bottom: 15px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span><input type="text"
								class="form-control" name="emailId"
								value="<%=session.getAttribute("emailId")%>" readonly>
						</div>
						<div class="from-group">
							<label class="input-head">OTP</label>
							<div style="margin-bottom: 15px" class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span><input type="text"
									class="	form-control" name="otp"
									placeholder="Enter OTP" required maxlength="6">
							</div>
						</div>
						<div class="from-group">
							<label class="input-head">Password</label>
							<div style="margin-bottom: 15px" class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span><input type="Password"
									class="	form-control" name="Password"
									placeholder="Enter Password" required>
							</div>
						</div>
						<div class="from-group">
							<label class="input-head">Confirm Password</label>
							<div style="margin-bottom: 15px" class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span><input type="Password"
									class="	form-control" name="confirmPassword"
									placeholder="Confirm Password" required>
							</div>
						</div>
						
						<div>
							<input type="submit" class="btn btn-primary" value="Reset">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<footer>
		<p class="pull-right">Copyright &copy 2017</p>
	</footer>
</body>
</html>