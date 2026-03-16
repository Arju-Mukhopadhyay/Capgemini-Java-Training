<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>

<style>

*{
    box-sizing: border-box;
}

body{A
    margin:0;
    font-family: Arial, Helvetica, sans-serif;
    background: linear-gradient(135deg,#89CFF0,#6DD5FA);
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
    width:380px;
}

h2{
    text-align:center;
    margin-bottom:20px;
}

table{
    width:100%;
    border-collapse:collapse;
}

td{
    padding:10px;
}

input[type=text],
input[type=password],
input[type=email]{
    width:100%;
    padding:10px;
    border-radius:6px;
    border:1px solid #ccc;
    outline:none;
    transition:0.3s;
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
    background:#6f42c1;
    color:white;
}

input[type=reset]{
    background:#e63946;
    color:white;
}

input[type=submit]:hover{
    background:#59339d;
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
    font-weight:bold;
    text-decoration:none;
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

<h2>Register</h2>

<form action="register" method="post">

<table border="1">

<tr>
<td>Full Name</td>
<td><input type="text" name="name" placeholder="Enter your name" required></td>
</tr>

<tr>
<td>Email</td>
<td><input type="email" name="email" placeholder="Enter email" required></td>
</tr>

<tr>
<td>Username</td>
<td><input type="text" name="username" placeholder="Choose username" required></td>
</tr>

<tr>
<td>Password</td>
<td><input type="password" name="password" placeholder="Create password" required></td>
</tr>

<tr>
<td colspan="2" class="buttons">
<input type="submit" value="Register">
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