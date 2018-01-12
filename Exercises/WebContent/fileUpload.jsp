<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<form action="FileUploadServlet" method="post"
		enctype="multipart/form-data">
		<input type="file" id="file"> <input type="submit"
			value="upload" id="submit">
	</form>
	<script>
// 		function filename() {
// 			var file = document.getElementById("file").value;
// 			alert(file);
// 		}

		$(function(){
			$('#submit').click(function(){
				var file = $(this).html().val();
				alert(file);
			});
		});
	</script>
</body>
</html>