<!DOCTYPE html>
<html>
<head>
    <title>Employer Dashboard</title>
</head>
<body>

<h2>Welcome Employer</h2>

<p>Name: ${user.name}</p>
<p>Email: ${user.email}</p>
<p>Company: ${user.companyName}</p>

<hr>

<a href="/employer/post-job">Post Job</a><br><br>
<a href="/employer/my-jobs">View My Jobs</a>

<a href="/employer/edit">Edit Profile</a><br><br>

<a href="/employer/delete"
   onclick="return confirm('Are you sure?')">
   Delete Account
</a><br><br>

</body>
</html>