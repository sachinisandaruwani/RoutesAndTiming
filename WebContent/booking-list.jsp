<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
int i = 0;
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Booking List</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">

<!-- css -->
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/header-style2.css">
<link rel="stylesheet" href="css/footer-style.css">

</head>
<body id="booking-list">

	<!--NAVIGATION BAR-->
	<div class="navigation-bar">
		<nav>
			<!-- <input type="checkbox" id="check"> <label for="check" class="checkbtn"> <i class="fas fa-bars"></i>
            <a class="log" href="home.jsp"><img id="logo" src="IMG/logo.jpg" alt="logo" style="height: 100px;"></a> -->
			<ul class="nav-ul">
				<li><a id="nav" href="#">Home</a></li>
				<li><a id="nav" href="#">About Us</a></li>
				<li><a id="nav" href="#">Contact Us</a></li>
				<li><a id="nav" href="<%=request.getContextPath()%>">Routes</a></li>
				<li><a id="nav" href="#">Schedules</a></li>
				<li><a id="nav" href="#">Search</a></li>
			</ul>
		</nav>
	</div>

	<!-- content -->
	<div class="container">
		<table class="table color text-light mt-5 p-3 opacity-75">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Start</th>
					<th scope="col">Destination</th>
					<th scope="col">Date</th>
					<th scope="col">Time</th>
					<th scope="col">Vehicle ID</th>
					<th scope="col">Vehicle Type</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="booking" items="${boolingList}">
					<tr>
						<th scope="row"><%=i += 1%></th>
						<td><c:out value="${ booking.start }" /></td>
						<td><c:out value="${ booking.destination }" /></td>
						<td><c:out value="${ booking.date }" /></td>
						<td><c:out value="${ booking.time }" /></td>
						<td><c:out value="${ booking.vehicleID }" /></td>
						<td><c:out value="${ booking.vehicleType }" /></td>
						<td>
							<!-- set up a link for each booking --> <c:url var="updateLink"
								value="/RouteController">
								<c:param name="controlParam" value="LOAD" />
								<c:param name="bookingId" value="${String.valueOf(booking.id)}" />
							</c:url> <!--  set up a link to delete a booking --> <c:url
								var="deleteLink" value="/RouteController">
								<c:param name="controlParam" value="DELETE" />
								<c:param name="bookingId" value="${booking.id}" />
							</c:url> <a href="${ updateLink }" class="btn color bdr text-light">Update</a>
							<a href="${ deleteLink }" class="btn color bdr text-light"
							onclick="if (!(confirm('Are you sure you want to cancel this booking?'))) return false">Cancel</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>