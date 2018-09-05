<%@page import="com.campusnumerique.vehiclerental.bean.ReservationBean"%>
<%@page import="com.campusnumerique.vehiclerental.entity.Reservation"%>
<%@page import="com.campusnumerique.vehiclerental.entity.Client"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<jsp:useBean id="client" scope="session" class="com.campusnumerique.vehiclerental.bean.ClientBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Reservations List</title>

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
<!-- 	<script src="../resources/js/client.js"></script> -->
</head>
<body>

	<%@ include file="header.jsp"%>

	<div class="container" id="content">
		<div class="row">
			<h2>Reservations List</h2>
			<table id="userTable" class="table table-striped">
				<thead>
					<tr>
						<th>Vehicle</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Estimated Km</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<%
 					ArrayList<ReservationBean> resas = (ArrayList<ReservationBean>) request.getAttribute("resas");
 					for(ReservationBean resa : resas) {
 						out.println("<tr><td><a href='./'>" + resa.getCar().getBrand()+ " "+ resa.getCar().getModel() + "</a></td> <td>" + resa.getResa().getStartDate() + "</td> <td>" + resa.getResa().getEndDate() + "</td> <td>" + resa.getResa().getEstimatedKm() + "</td> <td>" + resa.getResa().getPrice() + " &euro;</td></tr>");
 					}
 					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>