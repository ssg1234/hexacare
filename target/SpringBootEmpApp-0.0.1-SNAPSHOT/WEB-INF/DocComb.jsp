<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<section>
		<h2>View Schedule for doctor</h2>
		<div align="center">
			<form action="viewbyavail">
				Specialization <select name="cbodoc">
					<c:forEach items="${doclist}" var="doc">
						<option value="${doc.docId}">${doc.dname}</option>
					</c:forEach>
				</select> <input type="submit" value="view" />
			</form>
		</div>
	</section>

</body>
</html>