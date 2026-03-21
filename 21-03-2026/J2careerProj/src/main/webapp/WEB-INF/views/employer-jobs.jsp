<!DOCTYPE html>
<html>
<head>
    <title>My Jobs</title>
</head>
<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>My Posted Jobs</h2>

<table border="1">
<tr>
    <th>Title</th>
    <th>Location</th>
    <th>Salary</th>
    <th>Applicants</th>
</tr>

<c:forEach var="job" items="${jobs}">
<tr>
    <td>${job.title}</td>
    <td>${job.location}</td>
    <td>${job.salary}</td>
    <td>
        <a href="/employer/applicants?jobId=${job.id}">
            View Applicants
        </a>
    </td>
</tr>
</c:forEach>
</table>

</body>
</html>