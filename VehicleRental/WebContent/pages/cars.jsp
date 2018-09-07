<%@page import="com.campusnumerique.vehiclerental.entity.Utilitary"%>
<%@page import="com.campusnumerique.vehiclerental.entity.Motorbike"%>
<%@page import="com.campusnumerique.vehiclerental.entity.Car"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="client" scope="session"
	class="com.campusnumerique.vehiclerental.bean.ClientBean" />
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
<link rel="shortcut icon" type="image/x-icon" href="resources/images/delorean.png" />
</head>
<body>

	<%@ include file="header.jsp" %>

	<div class="container" id="content">
		<div class="row">
			
			<h2>Cars List</h2>
			
			<table id="carTable" class="table table-striped">
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
					ArrayList<Car> carslist = (ArrayList<Car>) request.getAttribute("carslist");
					for(Car car : carslist){
						out.println("<tr><td>" +car.getBrand() + "</td> <td>" +car.getModel() + "</td> <td>" +car.getColor() + "</td> <td>" +car.getPlateNumber() + "</td> <td>" +car.getPrice() + "</td> <td>" +car.getKmPrice() + "</td> <td>" +car.getHorsePower() + "</td></tr> ");
					}
					%>
				</tbody>
			</table>
			
		</div>
		<div class="row">
			
			<h2>Motor Bikes List</h2>
			
			<table id="motoTable" class="table table-striped">
				<thead>		
					<tr>
						<th>Brand</th>
						<th>Model</th>
						<th>Color</th>
						<th>Plate Number</th>
						<th>Price</th>
						<th>Km price</th>
						<th>Cylinder</th>
					</tr>
				</thead>
				<tbody>
					<% 
					ArrayList<Motorbike> motoslist = (ArrayList<Motorbike>) request.getAttribute("motoslist");
					for(Motorbike moto : motoslist){
						out.println("<tr><td>" +moto.getBrand() + "</td> <td>" +moto.getModel() + "</td> <td>" +moto.getColor() + "</td> <td>" +moto.getPlateNumber() + "</td> <td>" +moto.getPrice() + "</td> <td>" +moto.getKmPrice() + "</td> <td>" +moto.getCylinder() + "</td></tr> ");
					}
					%>
				</tbody>
			</table>
			
		</div>
		<div class="row">
			
			<h2>Utilitaries List</h2>
			
			<table id="utilitaryTable" class="table table-striped">
				<thead>		
					<tr>
						<th>Brand</th>
						<th>Model</th>
						<th>Color</th>
						<th>Plate Number</th>
						<th>Price</th>
						<th>Km price</th>
						<th>Volume</th>
					</tr>
				</thead>
				<tbody>
					<% 
					ArrayList<Utilitary> utilitarieslist = (ArrayList<Utilitary>) request.getAttribute("utilitarieslist");
					for(Utilitary utilitary : utilitarieslist){
						out.println("<tr><td>" +utilitary.getBrand() + "</td> <td>" +utilitary.getModel() + "</td> <td>" +utilitary.getColor() + "</td> <td>" +utilitary.getPlateNumber() + "</td> <td>" +utilitary.getPrice() + "</td> <td>" +utilitary.getKmPrice() + "</td> <td>" +utilitary.getVolume() + "</td></tr> ");
					}
					%>
				</tbody>
			</table>
			
		</div>
	</div>
</body>
</html>