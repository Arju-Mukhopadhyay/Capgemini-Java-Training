<!DOCTYPE html>
<html>
<head>
    <title>Post Job</title>
</head>
<body>

<h2>Post Job</h2>

<form action="/employer/save-job" method="post">

    Title: <input type="text" name="title" /><br><br>
    Description: <input type="text" name="description" /><br><br>
    Location: <input type="text" name="location" /><br><br>
    Salary: <input type="number" name="salary" /><br><br>

    <button type="submit">Post Job</button>

</form>

</body>
</html>