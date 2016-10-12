<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Hiber.Product"%>
<%@page import="Hiber.Cart"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
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

		<b>Your Items to checkout</b><br /><br />
		<table class="table table-bordered table-striped table-hover"
			id="myTable">
			<thead>
				<tr>
					<b>
						<th>Item Name</th>
						<th>Description</th>
					<th>Price</th>
					<th>Shipping Cost</th>
					<th>Tax</th>
					</b>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="order" items="${cart.orders}">
					<tr>
						<td><c:out value="${order.product.productname}" /></td>
						<td><c:out value="${order.product.productdescription}" /></td>
						<td><c:out value="${order.sellingprice}" /></td>
						<td><c:out value="${order.shippingcost}" /></td>
						<td><c:out value="${order.tax}" /></td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
			<br/>
			<table class="table table-bordered table-striped table-hover"
			id="table">
			<thead>
				<tr>
					<b>
						<th><p>Total</p></th>
						<th><p style="text-align:right"><c:out value="${cart.subtotal}" /></th>
					</b>
				</tr>
			</thead>
		</table>
		<p>
			<a href="Checkout"><img src="images/checkout.png" height="50"
				width="50" />Check out</a>
		</p>

	</div>
</body>

</body>
</html>