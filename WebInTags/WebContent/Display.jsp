<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="emp" class="in.vamsoft.Employee.Employee" scope="request"></jsp:useBean>
${param.na}
Id<jsp:getProperty property="empid" name="emp"/><br>
Name<jsp:getProperty property="name" name="emp"/><br>
Salary<jsp:getProperty property="salary" name="emp"/><br>
DeptId<jsp:getProperty property="deptid" name="emp"/>
</body>
</html>