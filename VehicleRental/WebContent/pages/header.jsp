<nav class="navbar navbar-light " id="header">
	<a class="navbar-brand" href="./reservationsList"> <img
		src="resources/images/delorean.png" />
	</a>
	<ul class="nav nav-pills">
		<%
			if (client.getLogin() != "NoUserConnected") {
				if (client.getClient().isAgent()) {
					out.println("<li class='nav-item'><a class='nav-link' href='./clients'>Clients List</a></li>");
				}
				out.println("<li class='nav-item'><a class='nav-link' href='./cars'>Vehicles List</a></li>");
				out.println("<li class='nav-item'><a class='nav-link' href='./reservation'>Book a car</a></li>");	
				if (client.getClient().isAgent()) {
					out.println("<li class='nav-item'><a class='nav-link' href='./allReservations'>All Reservations</a></li>");
				}
				out.println("<li class='nav-item'><a class='nav-link' href='./logout'>Logout</a></li>");
			}
		%>
		
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li>User Connected: ${client.login }</li>
	</ul>
</nav>