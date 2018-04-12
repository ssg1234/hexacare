<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<%@include file="HeadSection.jsp"%>
<style> 
 input[type=submit]  {
    background-color: #00BFFF;
    border: none;
    color: white;
    padding: 16px 32px;
    text-decoration: none;
    margin: 4px 2px;
    cursor: pointer;
}
</style>
<body>
	<%@include file="Header.jsp"%>

	<div style="height: 500px;" align="center" id="background">
		<h2>Your Visits</h2>
		<form action="patienthistory" onsubmit="return checkCon()">
			Enter Your Contact Number: <input type="text" id="txtnum" name="txtnum" /> <input
				type="submit" class=but1 value="search"  />
			<form:errors name="txtnum" cssStyle="color:red" element="div" />
		</form>
	</div>

	<%@include file="Footer.jsp"%>
</body>
</html>