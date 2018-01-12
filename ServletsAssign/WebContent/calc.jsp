<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin-left: 400px; margin-top: 250px">
		<form action="Calculate" method="post">
			<input type="text" name="op1" placeholder="Enter a value"> <input
				type="text" name="op2" placeholder="Enter b value"> <br>
			<div style="margin-left: 50px">
				<input type="radio" name="operation" value="add">Addition
				<input type="radio" name="operation" value="sub">Subtract
				<input type="radio" name="operation" value="mul">Multiply
				<input type="radio" name="operation" value="div">Division
				<br><input type="submit" value="=" style="margin-left:50px"> <input type="text"
					name="result" value="<%=session.getAttribute("result") %>">
			</div>
		</form>
	</div>
</body>
</html>