<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Booking</title>

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

<body id="booking-update">

	<!--NAVIGATION BAR-->
	<div class="navigation-bar">
		<nav>
			<!-- <input type="checkbox" id="check"> <label for="check" class="checkbtn"> <i class="fas fa-bars"></i>
            <a class="log" href="home.jsp"><img id="logo" src="IMG/logo.jpg" alt="logo" style="height: 100px;"></a> -->
			<ul class="nav-ul">
				<li><a id="nav" href="">Home</a></li>
				<li><a id="nav" href="#">About Us</a></li>
				<li><a id="nav" href="#">Contact Us</a></li>
				<li><a id="nav" href="<%=request.getContextPath()%>">Routes</a></li>
				<li><a id="nav" href="#">Schedules</a></li>
				<li><a id="nav" href="#">Search</a></li>
			</ul>
		</nav>
	</div>

	<!-- Display error message - required field -->
	<%
	if (request.getAttribute("nullError") != null) {
		out.print("<div class=\"alert alert-danger alert-dismissible fade show\"" + " role=\"alert\">"
		+ " <strong>Error!</strong>" + " One or more required fields are empty"
		+ " <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\""
		+ " aria-label=\"Close\"></button>" + "</div>");
	}
	%>
	<!-- Display error message - select same station -->
	<%
	if (request.getAttribute("sameStation") != null) {
		out.print("<div class=\"alert alert-danger alert-dismissible fade show\"" + " role=\"alert\">"
		+ " <strong>Error!</strong>" + " You select same locations for start and end"
		+ " <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\""
		+ " aria-label=\"Close\"></button>" + "</div>");
	}
	%>
	<!-- Display success message -->
	<%
	if (request.getAttribute("success") != null) {
		out.print("<div class=\"alert alert-success alert-dismissible fade show\"" + " role=\"alert\">"
		+ " <strong>Success</strong>" + " Route is saved"
		+ " <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\""
		+ " aria-label=\"Close\"></button>" + "</div>");
	}
	%>

	<!-- content -->
	<div class="container">
		<div class="row justify-content-sm-center">
			<!-- form -->
			<form action="RouteController" method="POST" id="booking-form"
				class="text-light mt-5 p-3 col-sm-9">
				<!-- start station -->
				<div class="row mb-3">
					<label for="startStation" class="col-sm-2 col-form-label">Start</label>
					<div class="col-sm-10">
						<input type="text" class="col-sm-12" name="start" value="${ getBooking.start }">
					</div>
				</div>
				<!-- end station -->
				<div class="row mb-3">
					<label for="endStation" class="col-sm-2 col-form-label">Destination</label>
					<div class="col-sm-10">
						<input type="text" class="col-sm-12" name="destination" value="${ getBooking.destination }">
					</div>
				</div>
				<!-- Date -->
				<div class="row mb-3">
					<label for="date" class="col-sm-2 col-form-label">Date</label>
					<div class="col-sm-10">
						<input type="date" class="form-control color text-light" id="date"
							placeholder="" name="bookingDate" value="${ getBooking.date }">
					</div>
				</div>
				<!-- time -->
				<div class="row mb-3">
					<label for="time" class="col-sm-2 col-form-label">Time</label>
					<div class="col-sm-10">
						<select id="time" class="form-select color text-light" name="time">
							<option value="${ getBooking.time }" selected="selected" hidden>${ getBooking.time }</option>
							<option>00:00:00</option>
							<option>01:00:00</option>
							<option>02:00:00</option>
							<option>03:00:00</option>
							<option>04:00:00</option>
							<option>05:00:00</option>
							<option>06:00:00</option>
							<option>07:00:00</option>
							<option>08:00:00</option>
							<option>09:00:00</option>
							<option>10:00:00</option>
							<option>11:00:00</option>
							<option>12:00:00</option>
						</select>
					</div>
				</div>
				<!-- train type -->
				<div class="row mb-3">
					<label for="trainType" class="col-sm-2 col-form-label">Train
						Type</label>
					<div class="col-sm-10">
						<input type="text" class="col-sm-12" name="start" value="${ getBooking.vehicleID }">
					</div>
				</div>
				<!-- train class -->
				<div class="row mb-3">
					<label for="trainClass" class="col-sm-2 col-form-label">Class</label>
					<div class="col-sm-10">
						<input type="text" class="col-sm-12" name="start" value="${ getBooking.vehicleType }">
					</div>
				</div>

				<!-- hidden field -->
				<input type="hidden" name="bookingID" value="${ getBooking.id }">
				<input type="hidden" name="controlParam" value="update-booking">
				<!--  -->
				<div class="row">
					<div class="col-sm-6">
					<!--
						<c:url var="myBooking" value="/RouteController">
							<c:param name="controlParam" value="bookingList" />
						</c:url>
						<a href="${myBooking}" class="btn color bdr text-light">My
							Booking</a>
							-->
					</div>
					<!-- submit -->
					<div class="col-sm-6">
						<button type="submit"
							class="btn color bdr text-light mb-3 float-end">Update</button>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>

</html>