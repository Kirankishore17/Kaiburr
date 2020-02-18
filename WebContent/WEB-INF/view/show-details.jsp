<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
<head>
<title>student confirmation</title>
</head>
<body>

	<table>
		<c:forEach var="student" items="${list}">
		<tr><td>${student.id}</td> <td>${student.name}</td> <td>${student.language}</td> <td>${student.framework}</td></tr>
		</c:forEach>
	</table>
	<a href="/kaiburr_task1">return</a>

</body>

</html>