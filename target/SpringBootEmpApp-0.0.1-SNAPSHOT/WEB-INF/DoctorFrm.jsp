<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<section>
	<h2>Our Doctors</h2>
	<div align="center">
		
			<table border="1" >

				<tr>
					<th>Doctor ID</th>
					<th>Doctor Name</th>
					<th>Doctor Email</th>
					<th>Doctor Contact</th>
					<th>Specialization</th>
				</tr>
				<c:forEach var="doc" items="${doclist}">
					<tr>
						<td><c:out value="${doc.docId}" /></td>
						<td><c:out value="${doc.dname}" /></td>
						<td><c:out value="${doc.dcontact}" /></td>
						<td><c:out value="${doc.demail}" /></td>
						<td><c:out value="${doc.spec.specName}" /></td>
					</tr>
				</c:forEach>
			</table>

	</div>
</section>

</body>
</html>