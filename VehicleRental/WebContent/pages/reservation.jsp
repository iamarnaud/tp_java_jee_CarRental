<%@page import="com.campusnumerique.vehiclerental.entity.Client"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<jsp:useBean id="client" scope="session"
	class="com.campusnumerique.vehiclerental.bean.ClientBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Réservation</title>

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
			<h2>Book a car</h2>
		</div>

		<div class="row">
			<form method="post" action="inscription">
				<fieldset>
					<legend>When do you want to drive ? </legend>
					<p>Choose when and where...</p>
					<input type="hidden" id="clientId" name="clientId" value="<% out.println(request.getParameter("id")); %>"> <label
						for="datedebut">Date début <span class="requis">*</span></label> <input
						type="date" id="datedebut" name="datedebut" value="" size="20" />
					<br /> <label for="datefin">Date fin <span class="requis">*</span></label>
					<input type="date" id="datefin" name="datefin" value="" size="20" />
					<br /> <label for="kmestime">KM estimés <span
						class="requis">*</span></label> <input type="number" id="kmestime"
						name="kmestime" value="1" min="1" size="20" /> <br /> <input
						type="submit" value="BOOK" class="sansLabel" /> <br />
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>
