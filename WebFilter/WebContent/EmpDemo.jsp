<%@page import="in.vamsoft.dao.HibernateDaoImpl"%>
<%@page import="in.vamsoft.services.ServiceDao"%>
<%@page import="in.vamsoft.dao.EmpDao"%>
<%@page import="in.vamsoft.model.Employee"%>
<%@page import="in.vamsoft.model.Department"%>
<%@page import="java.util.List"%>
<%@page import="in.vamsoft.services.EmpServices"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
a:link {
    color:#00ff00;
    background-color: transparent;
    text-decoration: none;
}



a:hover {
    color: red;
    background-color: transparent;
    text-decoration: underline;
}

a:active {
    color: yellow;
    background-color: transparent;
    text-decoration: underline;
}
</style> 
</head>
<body>
	<form action="EmployeeDetails" method="post" class="form-group">
		<select name="deptId" class="form-control">
			<%
				HibernateDaoImpl services = new HibernateDaoImpl();
				List<Department> departments = services.getAllDept();
			  for (Department d : departments) {
			%>

			<option value="<%=d.getDeptNo()%>"><%=d.getDeptName()%></option>
			<%
			  }
			%>
		</select> 
		<input type="submit" value="get" name="operation"><br>
		<a href="AddEmployee.html">AddEmployee</a><br>
		<a href="DeleteEmployee.jsp">DeleteEmployee</a>
	</form>
</body>
</html>