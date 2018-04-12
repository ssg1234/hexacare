<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="HeadSection.jsp"%>

<body>
	<%@include file="Header.jsp"%>
	<div id="background">
		<h2>Error Page</h2>
		<div style="color: red; height: 500px;" align="center">${err}</div>
	</div>

	<%@include file="Footer.jsp"%>

</body>
</html>