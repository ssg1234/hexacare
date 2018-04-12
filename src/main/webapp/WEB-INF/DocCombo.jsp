
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<select name="cbodoc" onchange="displayAvail(this.value)">
	<c:forEach items="${doctlist}" var="doc">
		<option value="${doc.docId}">${doc.dname}</option>

	</c:forEach>
</select>

