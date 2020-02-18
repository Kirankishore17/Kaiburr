<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Registration Form</title>
</head>

<body>

	<form:form action="addEntry" modelAttribute="student">
	
		Name: <form:input path="name" />
		
		<br><br>
		
		Programming language:
		
		<br>
		
		Java <form:radiobutton path="language" value="Java"/>
		Python <form:radiobutton path="language" value="Python"/>
		C++ <form:radiobutton path="language" value="C++"/>
		<br><br>
		
		Framework:  <form:input path="framework" />
		
		<br><br>
		
		<input type="submit" value="Submit" />
	
	</form:form>


</body>

</html>
 