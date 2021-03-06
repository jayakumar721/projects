<%@page import="in.vamsoft.services.EmpServices"%>
<%@page import="in.vamsoft.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>empview</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
th {
	background-color: #435;
	color: #fff;
	padding: 20px;
}

tr:hover {
	background-color: #ccffff;
}

th, td {
	text-align: center;
	padding: 200px;
}

.glyphicon-trash {
	color: red;
}
</style>



</head>
<body>
	<form method="post">
		<div class="col-md-12">
			<table class="table">

				<%
				  @SuppressWarnings("unchecked")
							List<Employee> list = (List<Employee>) session.getAttribute("employees");
							if (list.size() > 0) {
				%>
				<thead>
					<tr class="t1">
						<th>Employee Id</th>
						<th>Employee Name</th>
						<th>Employee Salary</th>
						<th>Employee Doj</th>
						<th>Dept No</th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<%
					  for (Employee l : list) {
					%>


					<tr id="as">
						<td><%=l.getEmpNo()%></td>
						<td><%=l.getEmpName()%></td>
						<td><%=l.getSalary()%></td>
						<td><%=l.getDate()%></td>
						<td><%=l.getDeptId()%></td>
						<td><a
							href="Update.jsp?id=<%=l.getEmpNo()%>&name=<%=l.getEmpName()%>&salary=<%=l.getSalary()%>&date=<%=l.getDate()%>&deptId=<%=l.getDeptId()%>"><i
								class="glyphicon glyphicon-pencil"></i></a></td>
						<td><a
							href="EmployeeDetails?id=<%=l.getEmpNo()%>&operation=delete&deptId=<%=l.getDeptId()%>">
								<i class="glyphicon glyphicon-trash"></i>
						</a></td>
					</tr>

					<%
					  }
								} else {
					%>
					<h1>Data not found</h1>
					<%
					  }
					%>
				</tbody>
			</table>
		</div>
	</form>
	<script>
		$(document).ready(function() {
			$("#as").hover(function() {
				$(this).animate({
					height : '50px'
				});

			});
			$("#as").mouseleave(function() {
				$(this).css("background-color", "yellow");

			});
		});
	</script>

</body>
</html>