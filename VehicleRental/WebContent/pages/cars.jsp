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
<link rel="shortcut icon" type="image/x-icon" href="resources/images/deloreansquare.png" />
<style>
    .popMenu {
        font-size: 1.5rem;
    }
    .icon-chevron-down,
    .icon-chevron-right {
        width: 30px;
        padding-left: 50px;
    }
    .icon-chevron-down,
    input[type=checkbox], 
    input[type=checkbox] ~ table {
          display: none;
      }
    input[type=checkbox]:checked ~ table {
        display: block;
    }
    input[type=checkbox]:checked ~ label .icon-chevron-down{
        display: inline;
    }
    input[type=checkbox]:checked ~ label .icon-chevron-right{
        display: none;
    }
    hr {
    margin-top: 6px;
    }
    .arrowPics {
    width: 30px;
    margin-top: -5px;
    }
</style>
</head>
<body>

	<%@ include file="header.jsp" %>

	<div class="container" id="content">
		<div class="row">
			<div class="col-12 menu-entry">
				<input type="checkbox" id="cBox1" name="cBox1">
				<label for="cBox1" class="popMenu" style="font-size: 2rem; text-transform: uppercase;">
					<span>Cars List</span>
					<span class="icon-chevron-right"><img class="arrowPics" src="resources/images/rightarrow.png" alt="right-arrow"></span>
        			<span class="icon-chevron-down"><img class="arrowPics" src="resources/images/downarrow.png" alt="down-arrow"></span>
				</label>
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
				<hr>
			</div>
		</div>
		<div class="row">
			<div class="col-12 menu-entry">
				<input type="checkbox" id="cBox2" name="cBox2">
				<label for="cBox2" class="popMenu" style="font-size: 2rem; text-transform: uppercase;">
					<span>Motor Bikes List</span>
					<span class="icon-chevron-right"><img class="arrowPics" src="resources/images/rightarrow.png" alt="right-arrow"></span>
        			<span class="icon-chevron-down"><img class="arrowPics" src="resources/images/downarrow.png" alt="down-arrow"></span>
				</label>
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
				<hr>
			</div>						
		</div>
		<div class="row">
			<div class="col-12 menu-entry">
				<input type="checkbox" id="cBox3" name="cBox3">
				<label for="cBox3" class="popMenu" style="font-size: 2rem; text-transform: uppercase;">
					<span>Utilitaries List</span>		
					<span class="icon-chevron-right"><img class="arrowPics" src="resources/images/rightarrow.png" alt="right-arrow"></span>
        			<span class="icon-chevron-down"><img class="arrowPics" src="resources/images/downarrow.png" alt="down-arrow"></span>
				</label>
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
				<hr>
			</div>			
		</div>
	</div>
</body>
</html>