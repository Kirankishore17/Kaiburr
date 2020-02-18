<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Deletion</title>
</head>

<body>
	<h3>Enter Student's Id to delete</h3>
	<form:form action="deleteEntry" >
	
		Id: <input type="text" name="id" />
		
		<br><br>
		
		<input type="submit" value="Submit" />
	
	</form:form>


</body>

</html>
 