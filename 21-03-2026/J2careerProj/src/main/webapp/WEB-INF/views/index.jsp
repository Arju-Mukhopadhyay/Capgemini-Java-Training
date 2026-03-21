<!DOCTYPE html>
<html>
<head>
    <title>Job Portal</title>
</head>
<body>

<h2>Welcome to Job Portal</h2>

<form action="/selectRole" method="post">

    <label>Select Role:</label>
    <select name="role" required>
        <option value="">--Select--</option>
        <option value="JOBSEEKER">Job Seeker</option>
        <option value="EMPLOYER">Employer</option>
    </select>

    <br><br>

    <button type="submit" name="action" value="login">Login</button>
    <button type="submit" name="action" value="register">Register</button>

</form>

</body>
</html>