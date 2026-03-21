<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Register</h2>

<form method="get">
    <label>Select Role:</label>
    <select name="role" onchange="this.form.submit()">
        <option value="">--Select--</option>
        <option value="JOBSEEKER" ${param.role == 'JOBSEEKER' ? 'selected' : ''}>Job Seeker</option>
        <option value="EMPLOYER" ${param.role == 'EMPLOYER' ? 'selected' : ''}>Employer</option>
    </select>
</form>

<br>

<c:if test="${param.role == 'JOBSEEKER'}">
    <jsp:include page="jobseeker-register.jsp" />
</c:if>

<c:if test="${param.role == 'EMPLOYER'}">
    <jsp:include page="employer-register.jsp" />
</c:if>

</body>
</html>