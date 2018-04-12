<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<section>
	<h2>Available Days</h2>
	<div align="center">
		
			<table border="1" >

				<tr>
					
					<th>Doctor Name</th>
					<th>Available date</th>
					
				</tr>
				<c:forEach var="avail" items="${availlist}">
					<tr>
						<td><c:out value="${avail.schdoc.dname}" /></td>
						<td><c:out value="${avail.schDate}" /></td>
					</tr>
				</c:forEach>
			</table>
		
	</div>
</section>

</body>
</html>