<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Hiber.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product</title>
</head>
<body>
	<jsp:include page="bootstrap.jsp"></jsp:include>

	<jsp:include page="navbar.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="container">

		<table class="table table-bordered table-striped table-hover"
			id="myTable">
			<thead>
				<b><c:out value="${currentproduct.productname}" /></b>
				<br>
				<br>
				<br>
			</thead>
			<tbody>

				<img src="images/${currentproduct.productid}.jpg" height="400" width="400"/>
				<br>
				<br>
				<br>

				<tr>
					<c:out value="${currentproduct.productdescription}" />
				</tr>
			</tbody>

		</table>
		<p>
			<a href="CartServlet?addproduct=${currentproduct.productid} "><img
				src="images/add-to-cart-light.png" height="30" width="30" />Add to
				Cart</a>
		</p>

	</div>
</body>
</html>