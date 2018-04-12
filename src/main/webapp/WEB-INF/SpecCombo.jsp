<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<%@include file="HeadSection.jsp"%>

<body>
	<%@include file="Header.jsp"%>
	<div align="center" id="background">
		<h2>View Doctor by specialization</h2>
		<form action="viewbyspec">
			Specialization <select name="cbospec">
				<c:forEach items="${speclist}" var="spec">
					<option value="${spec.specName}">${spec.specName}</option>
				</c:forEach>
			</select> <input type="submit" value="view" />
		</form>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>