<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="emp" class="in.vamsoft.Employee.Employee" scope="request"/>

<jsp:setProperty property="empid" name="emp" param="id"/>
<jsp:setProperty property="name" name="emp" param="name"/>
<jsp:setProperty property="salary" name="emp" param="salary"/>
<%-- <jsp:setProperty property="doj" name="emp" param="doj"/> --%>
<jsp:setProperty property="deptid" name="emp" param="deptId"/>

<jsp:forward page="Display.jsp">
<jsp:param value="jk" name="na"/>
</jsp:forward>
</body>
</html>