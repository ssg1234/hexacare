<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<%@include file="HeadSection.jsp"%>

<body>
	<%@include file="Header.jsp"%>
	<div align="center" id="background" style="height: 500px;">
		<h2 align="center">Appointment History</h2>
		<form action="viewspec">
			<table border="1" id="tlist" class="rowcolor">

				<tr>
					<th>Appointment Id</th>
					<th>Patient Name</th>
					<th>Patient Contact</th>
					<th>Doctor Name</th>
					<th>Specialization</th>
					<th>Appointment Date</th>
				</tr>
				<c:forEach var="his" items="${hislist}">
					<tr>
						<td><c:out value="${his.aptId}" /></td>
						<td><c:out value="${his.pName}" /></td>
						<td><c:out value="${his.pContactNum}" /></td>
						<td><c:out value="${his.aptdoc.dname}" /></td>
						<td><c:out value="${his.aptdoc.spec.specName}" /></td>
						<td><c:out value="${his.sch.schDate}" /></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	<%@include file="Footer.jsp"%>