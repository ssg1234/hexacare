<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HexaCare Hospitals</title>
<link href="hexa.css" rel="stylesheet">
<script type="text/javascript">
	function checkCon() {
		var str = document.getElementById("txtnum").value;

		if (str.trim().length <= 0 || isNaN(str)) {
			alert("please enter a valid contact number");
			return false;
		}

		return true;
	}
	
	function displaySubmit() {
		document.getElementById("submit").style.display="block";
	}
</script>
</head>








