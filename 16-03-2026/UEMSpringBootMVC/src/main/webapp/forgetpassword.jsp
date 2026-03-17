<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>

<style>

*{
    box-sizing:border-box;
}

body{
    margin:0;
    font-family:Arial, Helvetica, sans-serif;
    background:linear-gradient(135deg,#89CFF0,#6DD5FA);
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.container{
    background:white;
    padding:30px;
    border-radius:12px;
    box-shadow:0 10px 25px rgba(0,0,0,0.2);
    width:350px;
}

h2{
    text-align:center;
    margin-bottom:20px;
}

table{
    width:100%;
}

td{
    padding:10px;
}

input[type=text],
input[type=password]{
    width:100%;
    padding:10px;
    border-radius:6px;
    border:1px solid #ccc;
}

input:focus{
    border-color:#007BFF;
    box-shadow:0 0 5px rgba(0,123,255,0.5);
}

.buttons{
    text-align:center;
}

input[type=submit],
input[type=reset]{
    padding:10px 18px;
    border:none;
    border-radius:6px;
    cursor:pointer;
    margin:5px;
    font-weight:bold;
}

input[type=submit]{
    background:#17a2b8;
    color:white;
}

input[type=reset]{
    background:#e63946;
    color:white;
}

input[type=submit]:hover{
    background:#117a8b;
}

input[type=reset]:hover{
    background:#c1121f;
}

.links{
    text-align:center;
    margin-top:15px;
}

.btn{
    display:inline-block;
    padding:10px 18px;
    margin:5px;
    border-radius:6px;
    text-decoration:none;
    font-weight:bold;
    color:white;
}

.login{
    background:#007BFF;
}

.login:hover{
    background:#0056b3;
}

</style>
</head>

<body>

<div class="container">

<h2>Forgot Password</h2>

<form action="forgetpassword" method="post">

<table border="1">

<tr>
<td>Username</td>
<td><input type="text" name="username" placeholder="Enter username" required></td>
</tr>

<tr>
<td>New Password</td>
<td><input type="password" name="password" placeholder="Enter new password" required></td>
</tr>

<tr>
<td colspan="2" class="buttons">
<input type="submit" value="Update Password">
<input type="reset" value="Reset">
</td>
</tr>

</table>

</form>

<div class="links">
<a href="/" class="btn login">Back to Login</a>
</div>

</div>

</body>

</html>