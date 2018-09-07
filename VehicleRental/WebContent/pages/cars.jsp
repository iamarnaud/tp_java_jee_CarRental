<%@page import="com.campusnumerique.vehiclerental.entity.Car"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
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
<link rel="stylesheet" href="resources/css/global.css" />
<!--  <script src="../resources/js/car.js"></script> -->
</head>
<body>

	<%@ include file="header.jsp"%>

	<div class="container" id="content">
		<div class="row">

			<h2>Vehicles List</h2>

			<table id="carTable" class="table table-striped">
				<thead>
					<tr>
						<th>Brand</th>
						<th>Model</th>
						<th>Color</th>
						<th>Plate Number</th>
						<th>Price</th>
						<th>Kmprice</th>
						<th>Horse Power</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${carslist}" var="car">
						<tr>
							<td>${car.brand}</td>
							<td>${car.model}</td>
							<td>${car.color}</td>
							<td>${car.plateNumber}</td>
							<td>${car.price}</td>
							<td>${car.kmPrice}</td>
							<td>${car.horsePower}</td>
						</tr>
					</c:forEach>

<!-- 					ArrayList -->
<!-- 					<Car> carslist = (ArrayList<Car>) -->
<!-- 					request.getAttribute("carslist"); for(Car car : carslist) -->
<!-- 					out.println(" -->
<!-- 					<tr> -->
<!-- 						<td>" +car.getBrand() + "</td> -->
<!-- 						<td>" +car.getModel() + "</td> -->
<!-- 						<td>" +car.getColor() + "</td> -->
<!-- 						<td>" +car.getPlateNumber() + "</td> -->
<!-- 						<td>" +car.getPrice() + "</td> -->
<!-- 						<td>" +car.getKmPrice() + "</td> -->
<!-- 						<td>" +car.getHorsePower() + "</td> -->
<!-- 					</tr> -->
<!-- 					"); }  -->
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>