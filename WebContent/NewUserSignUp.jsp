<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign Up</title>
</head>
<body>
	<center>
		<jsp:include page="bootstrapStudent.jsp"></jsp:include>

		<jsp:include page="navbar.jsp"></jsp:include>
		<br> <br> <br> <br> <br> <br> <br>
		<h3>Please Sign-up below</h3>
		<br> <br>
		<%if("yes".equalsIgnoreCase((String)request.getAttribute("exists"))){ %>
		<p>Email already exists. Try again.</p>
		<%} %>
		<form action="NewUserSignUpServlet" method="post">
			      Name:<input type="text" name="username" id="username"> <br><br>
			User Email: <input type="text" name="useremail" id="useremail"><br><br>
			  Password: <input type="password" name="password"
				id="password"> <br> <br> <br> <br> <input
				type="submit" value="Submit" id="submit" />
		</form>
		
		<br> <br> <br> <br> <br> <br> <br>
		<br>
	</center>
</body>
</html>