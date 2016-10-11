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
		
		<table class="table table-bordered table-striped table-hover"
			id="myTable">
			<thead>
				<tr>
					<th>Product Name</th>
					<th>Description</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<tr>
						<td><a href="ProductServlet?productid=${product.productid}"> <c:out value="${product.productname}"/> </a></td>
						<td><c:out value="${product.productdescription}" /></td>
						<td><c:out value="${product.price}" />
						</td>

						<c:if test="${restaurants.average <0}">
							<td>No rating Available</td>
						</c:if>
						<c:if test="${user.userrole=='user'}">
							<td><a
								href="Review.jsp?restaurantid=<c:out value="${restaurants.restaurant.rid}"/>"><button>Add
										Review</button></a></td>
						</c:if>
						<c:if test="${user.userrole=='admin'}">
							<td><a
								href="EditRestaurant?restaurantid=<c:out value="${restaurants.restaurant.rid}"/>"><button>Edit
										Restaurant</button></a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>

	<br>
	<br>
	<br>
</body>
</html>