
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<select name="cboavail" onchange="displaySubmit()">
	<c:forEach var="avail" items="${availlist}">
		<option value="${avail.schId}">${avail.schDate}
			</option>
	</c:forEach>
</select>