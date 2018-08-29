<%@page import="com.campusnumerique.vehiclerental.entity.Car"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Car List</title>

<!-- JQuery 3.3.1 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<!-- Bootstrap 4.1.3 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<!-- General -->
<link rel="stylesheet" href="../resources/css/global.css" />

<!-- 
<script src="../resources/js/client.js"></script> 
-->
</head>
<body>

	<nav class="navbar navbar-light " id="header"> <a
		class="navbar-brand" href="#"> <img
		src="../resources/images/delorean.png" />
	</a>
	<ul class="nav nav-pills">
		<li class="nav-item"><a class="nav-link" href="./ClientServlet">Client
				List</a></li>
		<li class="nav-item"><a class="nav-link" href="./CarServlet">Car
				List</a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li></li>
	</ul>

	</nav>

	<div class="container">
		<div class="row">
			<h2>Car List</h2>
			<table id="userTable" class="table table-striped">
				<thead>
					<tr>
						<th>Brand</th>
						<th>Model</th>
						<th>Color</th>
						<th>Plate Number</th>
						<th>Price</th>
						<th>Km price</th>
						<th>Horse Power</th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<Car> cars = (ArrayList<Car>) request.getAttribute("cars");
						for (Car car : cars) {
							out.println("<tr><td>"+car.getBrand()+"</td><td>"+car.getModel()+"</td><td>"+car.getColor()+"</td><td>"+car.getPlateNumber()+"</td><td>"+car.getPrice()+"</td><td>"+car.getKmPrice()+"</td><td>"+car.getHorsePower()+"</td></tr>");
						}
					%>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>