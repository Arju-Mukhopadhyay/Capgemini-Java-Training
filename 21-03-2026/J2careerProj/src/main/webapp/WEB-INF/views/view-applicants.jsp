<!DOCTYPE html>
<html>
<head>
    <title>Applicants</title>
</head>
<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Applicants List</h2>

<table border="1">
<tr>
    <th>Name</th>
    <th>Email</th>
    <th>Skills</th>
    <th>Status</th>
</tr>

<c:forEach var="app" items="${applications}">
<tr>
    <td>${app.jobSeeker.name}</td>
    <td>${app.jobSeeker.email}</td>
    <td>${app.jobSeeker.skills}</td>
    <td>${app.status}</td>
</tr>
</c:forEach>

</table>

</body>
</html>