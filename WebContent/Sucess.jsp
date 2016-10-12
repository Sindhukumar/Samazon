<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Hiber.Users"%>
<%@page import="Hiber.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Home</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
</head>


<body>
	<jsp:include page="bootstrap.jsp"></jsp:include>

	<jsp:include page="navbar.jsp"></jsp:include>
<br><br><br><br><br>
	<div class="container">
		
		<h1> Success! Your order is placed.</h1>
		<h6>Payment: Cash On Delivery</h6>
		<br><br>
		<h5>Thank you for shopping with us.</h5>
		
		<h5><a href="Home">Continue Shopping...</a></h5>
	</div>

	<br>
	<br>
	<br>
</body>
</html>