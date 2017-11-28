<%@page import="java.time.LocalDate"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<title>login</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	  ServletContext context = this.getServletContext();
	  Double discount = (Double) context.getAttribute("discount");
	  Double gst = (Double) context.getAttribute("gst");
	  double total = 0.0;
	  double subTotal = 0.0;
	  double gstVal=0.0;
	  double discountVal=0.0;
	  HashMap<String, Double> bill = (HashMap<String, Double>) getServletContext().getAttribute("bill");
	  System.out.println("bill map" + bill);
	  for (Map.Entry<String, Double> entry : bill.entrySet()) {
	    subTotal = subTotal + entry.getValue();
	    gstVal = entry.getValue() * gst;
	    discountVal = entry.getValue() * discount;
	    total = total+(entry.getValue() +gstVal  - discountVal);
	  }
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="invoice-title">
					<h2>Order #12345</h2>
					<hr>
				</div>
				<div class="row">
					<div class="col-xs-6">
						<address>
							<strong>Billed To:<h2><%=request.getParameter("name")%></h2></strong>
							<h5><%=request.getParameter("address")%></h5>
							<h5><%=request.getParameter("contact")%></h5>
						</address>
					</div>

				</div>

			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<strong>Order placed on <%=LocalDate.now() %></strong>
						</h3>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-condensed">
								<thead>
									<tr>
										<td><strong>Product</strong></td>
										<td class="text-right"><strong>Price</strong></td>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${bill}" var="product">

										<!-- foreach ($order->lineItems as $line) or some such thing here -->
										<tr>
											<td class="col-md-3">
												<div class="media">
												
													<div class="media-body">
														<h4 class="media-heading">${product.key}</h4>

													</div>
												</div>
											</td>
											<td class="text-right">${product.value}</td>


										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="col-md-6">
					<h3 class="text-center">Order Summary</h3>
					<hr>
					<div class="pull-left">
						<h4>Subtotal</h4>
					</div>
					<div class="pull-right">
						<h4 class="text-right"><%=subTotal%></h4>
					</div>
					<div class="clearfix"></div>
					<div class="pull-left">
						<h4>Gst</h4>
					</div>
					<div class="pull-right">
						<h4 class="text-right"><%=gstVal%></h4>
					</div>
					<div class="clearfix"></div>
					<div class="pull-left">
						<h4>Discount</h4>
					</div>
					<div class="pull-right">
						<h4 class="text-right"><%=discountVal%></h4>
					</div>
					<div class="clearfix"></div>
					<div class="pull-left">
						<h4>Order Total</h4>
					</div>
					<div class="pull-right">
						<h4 class="text-right"><%=total%></h4>
					</div>
					<div class="clearfix"></div>
				</div>

				<div class="col-md-6 offset-md-2 align-center">
					<h3 class="text-center">Shipment Details:</h3>
					<address>
						<strong>Shipped To:</strong>
						<h2><%=request.getParameter("name")%></h2>
						<h4><%=request.getParameter("address")%></h4>
						<h4><%=request.getParameter("contact")%></h4>
					</address>
				</div>
			</div>
		</div>
	</div>
</body>
</html>