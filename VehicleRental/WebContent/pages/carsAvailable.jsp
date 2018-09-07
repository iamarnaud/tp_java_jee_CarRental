<%@page import="com.campusnumerique.vehiclerental.entity.Utilitary"%>
<%@page import="com.campusnumerique.vehiclerental.entity.Motorbike"%>
<%@page import="com.campusnumerique.vehiclerental.bean.ReservationBean"%>
<%@page import="com.campusnumerique.vehiclerental.entity.Reservation"%>
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
<link rel="stylesheet" href="<c:url value="resources/css/global.css"/>" />
<!--  <script src="../resources/js/car.js"></script> -->
<link rel="shortcut icon" type="image/x-icon" href="resources/images/deloreansquare.png" />
</head>
<body>

	<%@ include file="header.jsp"%>

	<div class="container" id="content">
		<div class="row">
			<h2>
				<%
					if (request.getAttribute("carslist") != null) {
						out.println("Available Cars");
					} else if (request.getAttribute("motoslist") != null) {
						out.println("Available Motorbikes");
					} else if (request.getAttribute("utilitarieslist") != null) {
						out.println("Available Utilitaries");
					}
				%>
			</h2>
		</div>
		<div class="row">
			<form method="post" action="./validation">
				<table id="carTable" class="table table-striped">
					<thead>
						<tr>
							<th>Selected</th>
							<th>Brand</th>
							<th>Model</th>
							<th>Color</th>
							<th>Plate Number</th>
							<th>Price</th>
							<th>Km price</th>
							<th>
								<%
									if (request.getAttribute("carslist") != null) {
										out.println("Horses Power");
									} else if (request.getAttribute("motoslist") != null) {
										out.println("Cylinder");
									} else if (request.getAttribute("utilitarieslist") != null) {
										out.println("Volume");
									}
								%>
							</th>
							<th>Estimated Price</th>
						</tr>
					</thead>
					<tbody>

						<%
						Reservation resa = (Reservation) request.getAttribute("resa");
						
							if (request.getAttribute("carslist") != null) {
								ArrayList<Car> carslist = (ArrayList<Car>) request.getAttribute("carslist");
								for (Car car : carslist) {
									out.println("<tr><td><input type='radio' name='carId' id='carId' value='" + car.getId()
											+ "'></td> <td>" + car.getBrand() + "</td> <td>" + car.getModel() + "</td> <td>"
											+ car.getColor() + "</td> <td>" + car.getPlateNumber() + "</td> <td>" + car.getPrice()
											+ "</td> <td>" + car.getKmPrice() + "</td> <td>" + car.getHorsePower() + "</td> <td>"
											+ car.getEstimatedPrice(resa.getEstimatedKm()) + " €" + "</td> </tr> ");
								}
							} else if (request.getAttribute("motoslist") != null) {
								ArrayList<Motorbike> motoslist = (ArrayList<Motorbike>) request.getAttribute("motoslist");
								for (Motorbike car : motoslist) {
									out.println("<tr><td><input type='radio' name='carId' id='carId' value='" + car.getId()
											+ "'></td> <td>" + car.getBrand() + "</td> <td>" + car.getModel() + "</td> <td>"
											+ car.getColor() + "</td> <td>" + car.getPlateNumber() + "</td> <td>" + car.getPrice()
											+ "</td> <td>" + car.getKmPrice() + "</td> <td>" + car.getCylinder() + "</td> <td>"
											+ car.getEstimatedPrice(resa.getEstimatedKm()) + " €" + "</td> </tr> ");
								}
							} else if (request.getAttribute("utilitarieslist") != null) {
								ArrayList<Utilitary> utilitarieslist = (ArrayList<Utilitary>) request.getAttribute("utilitarieslist");
								for (Utilitary car : utilitarieslist) {
									out.println("<tr><td><input type='radio' name='carId' id='carId' value='" + car.getId()
											+ "'></td> <td>" + car.getBrand() + "</td> <td>" + car.getModel() + "</td> <td>"
											+ car.getColor() + "</td> <td>" + car.getPlateNumber() + "</td> <td>" + car.getPrice()
											+ "</td> <td>" + car.getKmPrice() + "</td> <td>" + car.getVolume() + "</td> <td>"
											+ car.getEstimatedPrice(resa.getEstimatedKm()) + " €" + "</td> </tr> ");
								}
							}

						%>
					</tbody>
				</table>
				<button type="submit">Validate your car</button>
			</form>
			<div></div>
		</div>
</body>
</html>