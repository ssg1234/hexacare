<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="HeadSection.jsp"%>
<%@include file="Header.jsp"%>
</head>
<body>
	<div id="background">
		<section id="home">
			<h3 align="center" style="color: red;">${msg}</h3>

			<div>
				<nav>
					<table align="left" id="padd">

						<tr>
							<td><a href="viewdocs">Our Doctors</a></td>
						</tr>
						<tr>
							<td><a href="viewspec">Our Specializations</a></td>
						</tr>
						<tr>
							<td><a href="patientlog">Your Appointments</a></td>
						</tr>
						<tr>
							<td><a href="bookapt">Book Your Appointments</a></td>
						</tr>

					</table>

				</nav>
			</div>

		</section>
	</div>
	<%@include file="Footer.jsp"%>

</body>
</html>