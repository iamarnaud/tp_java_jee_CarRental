<%@page import="com.campusnumerique.vehiclerental.entity.Car"%>
<%@page import="com.campusnumerique.vehiclerental.entity.Client"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="head.jsp" %>
<body>
	<%@ include file="header.jsp" %>

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