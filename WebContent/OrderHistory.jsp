<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Hiber.Product"%>
<%@page import="Hiber.Cart"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order History</title>
</head>
<body>
	<jsp:include page="bootstrap.jsp"></jsp:include>

	<jsp:include page="navbar.jsp"></jsp:include>
	<br>
	<br>
	<div class="container">

		<b>Your Past Orders </b><br /> <br />

		<c:forEach var="receipt" items="${history}">


			<table class="table table-bordered table-striped table-hover"
				id="table">
				<thead>
					<tr>
						<b>
							<th><div>
									on
									<c:out value="${receipt.invoice.invoicedate}" />
								</div></th>
							<th>

								<div style="text-align: right">
									Invoice ID:
									<c:out value="${receipt.invoice.invoiceid}" />
								</div>
						</th>
						</b>
					</tr>
				</thead>
			</table>
			<c:forEach var="order" items="${receipt.orders}">
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
						<tr>
							<td><c:out value="${order.product.productname}" /></td>
							<td><c:out value="${order.product.productdescription}" /></td>
							<td><c:out value="${order.sellingprice}" /></td>
							<td><c:out value="${order.shippingcost}" /></td>
							<td><c:out value="${order.tax}" /></td>
						</tr>
					</tbody>
				</table>
				<table class="table table-bordered table-striped table-hover"
					id="table">
					<thead>
						<tr>
							<b>
								<th>Total:</th>
								<th><div style="text-align: right">
										<c:out value="${receipt.subtotal}" /></div></th>
							</b>
						</tr>
					</thead>
				</table>
			</c:forEach>
			<br><br>
		</c:forEach>


	</div>
</body>

</body>
</html>