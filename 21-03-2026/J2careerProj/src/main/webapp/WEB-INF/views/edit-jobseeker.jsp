<!DOCTYPE html>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>

<h2>Edit Profile</h2>

<form action="/jobseeker/update" method="post">

    <input type="hidden" name="id" value="${jobSeeker.id}" />

    Name: <input type="text" name="name" value="${jobSeeker.name}" /><br><br>
    Email: <input type="email" name="email" value="${jobSeeker.email}" /><br><br>
    Password: <input type="password" name="password" value="${jobSeeker.password}" /><br><br>
    Skills: <input type="text" name="skills" value="${jobSeeker.skills}" /><br><br>

    <button type="submit">Update</button>

</form>

</body>
</html>