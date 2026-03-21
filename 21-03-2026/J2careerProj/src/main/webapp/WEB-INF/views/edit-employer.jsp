<!DOCTYPE html>
<html>
<head>
    <title>Edit Employer</title>
</head>
<body>

<h2>Edit Profile</h2>

<form action="/employer/update" method="post">

    <input type="hidden" name="id" value="${employer.id}" />

    Name: <input type="text" name="name" value="${employer.name}" /><br><br>
    Email: <input type="email" name="email" value="${employer.email}" /><br><br>
    Password: <input type="password" name="password" value="${employer.password}" /><br><br>
    Company: <input type="text" name="companyName" value="${employer.companyName}" /><br><br>

    <button type="submit">Update</button>

</form>

</body>
</html>