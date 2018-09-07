<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="client" scope="session"
	class="com.campusnumerique.vehiclerental.bean.ClientBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>

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
<link rel="stylesheet" type="text/css" href="resources/css/global.css" />
<!-- <c:url value='resources/css/global.css'/> -->
<!--  <script src="../resources/js/car.js"></script> -->
<link rel="shortcut icon" type="image/x-icon" href="resources/images/delorean-square.png" />
</head>
<body>

	<%@ include file="header.jsp"%>

	<div class="container" id="content">
		<div class="row">
			<h2>Login</h2>
		</div>
		<div class="row">
			<form method="post" action="./login">
				<fieldset>
	                <legend>Connexion</legend>
	                <p>Vous pouvez vous connecter via ce formulaire.</p>
	
	                <label for="nom">Adresse email <span class="requis">*</span></label>
	                <input type="email" id="email" name="email" value="" size="20" maxlength="60" />
	                <span class="erreur" style="color: red">${connexion.errors['email']}</span>
	                <br />
	
	                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
	                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
	                <span class="erreur" style="color: red">${connexion.errors['motdepasse']}</span>
	                <br />
	
	                <input type="submit" value="Connexion" class="sansLabel" />
	                <br />
	                
	                <p style="${empty connexion.errors ? 'color: green' : 'color: red'}">${connexion.result}</p>
	                <p style="color: red">${error}</p>
	            </fieldset>
			</form>
		</div>
	</div>
</body>
</html>