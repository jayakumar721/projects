<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "EmployeeDetails" method = "post">
EmployeeId:<input type = "text" name = "id" value="<%=request.getParameter("id") %>" readonly><br>
EmployeeName:<input type = "text" name = "name" value="<%=request.getParameter("name") %>"><br> 
EmployeeSalary:<input type = "text" name = "salary" value="<%=request.getParameter("salary") %>"><br>
EmployeeDoj:<input type = "text" name = "doj" value="<%=request.getParameter("date") %>"><br>
EmployeeDeptId:<input type = "text" name = "deptId" value="<%=request.getParameter("deptId") %>" readonly><br>
<input type ="submit" value="update" name="operation">
</form>
</body>
</html>