<!DOCTYPE html>
<html>
<head>
    <title>Job Seeker Dashboard</title>
</head>
<body>

<h2>Welcome Job Seeker</h2>

<p>Name: ${user.name}</p>
<p>Email: ${user.email}</p>
<p>Skills: ${user.skills}</p>

<hr>

<a href="/jobs?userId=${user.id}">View Jobs</a>



<a href="/jobseeker/edit?id=${user.id}">Edit Profile</a><br><br>

<a href="/jobseeker/delete?id=${user.id}"
   onclick="return confirm('Are you sure?')">
   Delete Account
</a>



</body>
</html>