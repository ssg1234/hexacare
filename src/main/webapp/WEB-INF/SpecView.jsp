<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<%@include file="HeadSection.jsp"%>

<body>
	<%@include file="Header.jsp"%>
	<div align="center" id="background">
		<h2>Our Specializations</h2>
		<form action="viewspec">
			<table border="1" id="spec" class="rowcolor">

				<tr>
					<th>Specialization ID</th>
					<th>Specialization Name</th>
				</tr>
				<c:forEach var="spec" items="${speclist}">
					<tr>
						<td><c:out value="${spec.specId}" /></td>
						<td><c:out value="${spec.specName}" /></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	<%@include file="Footer.jsp"%>