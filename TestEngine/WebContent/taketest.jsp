<%@page import="java.util.List"%>
<%@page import="in.vamsoft.model.Question"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<script type="text/javascript" src="path_to/jquery.js"></script>
<script type="text/javascript" src="path_to/jquery.simplePagination.js"></script>



<link type="text/css" rel="stylesheet"
	href="path_to/simplePagination.css" />


<script type="text/javascript">
	var sessionTimeout = 300;

	function DisplaySessionTimeout() {
		window.history.go(+1);
		sessionTimeout = sessionTimeout - 1;
		//document.getElementById("val").innerHTML=sessionTimeout;

		//if session is not less than 0
		if (sessionTimeout >= 0) {
			//call the function again after 1 minute delay

			window.setTimeout("DisplaySessionTimeout()", 1000);
		} else {
			//show message box
			//document.getElementById("val").innerHTML="TIME OUT";
			alert("Your current Session is over.");
			setTimeout(document.form.sub.click());
		}
	}

	var seconds = 0
	var minutes = 5
	document.form.time.value = '30'

	function display() {
		if (seconds <= 0) {
			seconds = 60
			minutes -= 1
		}
		if (minutes <= -1) {
			seconds = 0
			minutes += 1
		} else
			seconds -= 1
		document.getElementById("time").innerHTML = minutes + "M : " + seconds
				+ " S"
		setTimeout("display()", 1000)
	}

	$(function() {
		$("#page").pagination({
			items : 8,
			itemsOnPage : 4,
			cssStyle : 'light-theme'
		});
	});
</script>
<style type="text/css">
.timer {
	color: red;
	float: right;
	font-size: 20px;
	background-color: transparent;
	width: 100px;
	text-align: center;
}
</style>
</head>
<body onLoad="javascript:display();DisplaySessionTimeout();">
<%if(session.getAttribute("name")!=null){ %>
	<%@ include file="header.jsp"%>
	<%
	  List<Question> questions = (List<Question>) session.getAttribute("Questions");
	%>
	<form name="form" action="Results">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<label class="timer" id="time"></label>

			<form name="form1" id="page">
				<%
				  for (Question element : questions) {
				%>
				<div style="margin-top:20px;font-style:bold;"><%=element.getqNo()%>.<%=element.getQuestion()%></div>
				<div>
					<input type="radio" name="<%=element.getqNo()%>" value="<%=element.getOp1()%>"><%=element.getOp1()%><br>
					<input type="radio" name="<%=element.getqNo()%>" value="<%=element.getOp2()%>"><%=element.getOp2()%><br>
					<input type="radio" name="<%=element.getqNo()%>" value="<%=element.getOp3()%>"><%=element.getOp3()%><br>
					<input type="radio" name="<%=element.getqNo()%>" value="<%=element.getOp4()%>"><%=element.getOp4()%><br>

				</div>
						
				<%
				  }
				%>
			</form>
			<input type="submit" name="sub" value="submit">
		</div>
	</form>
<%} else {
  response.sendRedirect("Login.html");
}%>
</body>
</html>