<%@page import="java.util.function.Function"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<%@include file="HeadSection.jsp"%>
<head>
<script>
	function displayDoctor(specname) {
		var ajax = new XMLHttpRequest();
		ajax.open("GET", "choosespec?spname=" + specname, true);
		ajax.send();
	
		ajax.onreadystatechange = function() {
			if (ajax.readyState == 4 && ajax.status == 200) {
				var combo = ajax.responseText;
				document.getElementById("dcombo").innerHTML = combo;
				  
			}

		}
	}

	function displayAvail(docId) {
		var ajax = new XMLHttpRequest();
		ajax.open("GET", "choosedoc?cbodoc=" + docId, true);
		ajax.send();
		ajax.onreadystatechange = function() {
			if (ajax.readyState == 4 && ajax.status == 200) {
				var combo = ajax.responseText;
				document.getElementById("acombo").innerHTML = combo;
			}

		}
	}
</script>
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
</head>
<body>
	<%@include file="Header.jsp"%>
	
	<div id="background">
			<h2>Book your Appointment</h2>

			<form:form action="add" method="post" modelAttribute="aptbean">

				<table bgcolor="lightblue" style="margin: 0 auto" id=apt>

					<tr>
						<td >Patient Name</td>
						<td><form:input path="pName" /></td>
						<td><form:errors path="pName" cssStyle="color:red"
								element="div" /></td>
					</tr>
					<tr>
						<td>Patient contact number</td>
						<td><form:input path="pContactNum" /></td>
						<td><form:errors path="pContactNum" cssStyle="color:red"
								element="div" /></td>
					</tr>
					<tr>
						<td>Specialization</td>
						<td><form:select items="${spemap}"
								onchange="displayDoctor(this.value)" cssStyle="color:black"
								path="speci.specName" /></td>

					</tr>
					<tr>
						<td>Doctor</td>
						<td id="dcombo"></td>

					</tr>
					<tr>
						<td>Available dates</td>
						<td id="acombo"></td>

					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" id= "submit" style="display:none"
							value="confirm" /></td>

					</tr>

				</table>
			</form:form>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>