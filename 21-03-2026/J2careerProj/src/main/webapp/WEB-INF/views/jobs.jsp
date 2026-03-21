<!DOCTYPE html>
<html>
<head>
    <title>Job List</title>
</head>
<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Available Jobs</h2>
<p style="color:green">
    <c:if test="${param.msg == 'applied'}">
        Application Submitted Successfully!
    </c:if>

    <c:if test="${param.msg == 'exists'}">
        Already Applied for this Job!
    </c:if>
</p>

<table border="1">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Location</th>
        <th>Salary</th>
        <th>Action</th>
    </tr>

    <c:forEach var="job" items="${jobs}">
        <tr>
            <td>${job.title}</td>
            <td>${job.description}</td>
            <td>${job.location}</td>
            <td>${job.salary}</td>
            <td>
                <!-- ✅ FIXED: passing both jobId and jobSeekerId -->
                <a href="/apply?jobId=${job.id}&jobSeekerId=${userId}">Apply</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>