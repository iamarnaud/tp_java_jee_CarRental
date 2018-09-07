<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="com.campusnumerique.vehiclerental.entity.Client"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<jsp:useBean id="client" scope="session" class="com.campusnumerique.vehiclerental.bean.ClientBean" />
<jsp:useBean id="resa" scope="session" class="com.campusnumerique.vehiclerental.bean.ReservationBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Validation</title>

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
<link rel="shortcut icon" type="image/x-icon" href="resources/images/delorean.png" />
</head>
<body>
<div>Well done !!!!!!!</div>
</body>
</html>