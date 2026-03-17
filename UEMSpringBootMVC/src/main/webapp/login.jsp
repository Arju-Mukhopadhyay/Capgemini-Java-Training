<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<!-- 🔹 GOOGLE FONT -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif:wght@300;400;600&display=swap" rel="stylesheet">

<style>

/* ===== GLOBAL ===== */
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Noto Serif','Segoe UI',serif;
}

/* ===== BODY ===== */
body{
    background: radial-gradient(circle at center, #0a0f2c, #020617);
    color:#e0f7ff;
    min-height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

/* GRID BACKGROUND */
body::before{
    content:"";
    position:fixed;
    width:100%;
    height:100%;
    background-image:
        linear-gradient(rgba(0,255,255,0.05) 1px, transparent 1px),
        linear-gradient(90deg, rgba(0,255,255,0.05) 1px, transparent 1px);
    background-size:40px 40px;
    z-index:0;
}

/* CARD */
.container{
    position:relative;
    z-index:1;
    width:380px;
    padding:35px;
    background:rgba(2,6,23,0.9);
    border-radius:18px;
    border:1px solid rgba(0,255,255,0.25);
    box-shadow:0 0 25px rgba(0,255,255,0.15);
}

/* TITLE */
h2{
    text-align:center;
    margin-bottom:25px;
    color:#00ffff;
    font-weight:600;
    letter-spacing:1px;
}

/* MESSAGE */
.message{
    text-align:center;
    margin-bottom:15px;
    padding:8px;
    border-radius:6px;
    color:#ff4d4d;
    background:rgba(255,77,77,0.1);
    border:1px solid rgba(255,77,77,0.4);
}

/* FORM */
table{
    width:100%;
}

td{
    padding:10px 0;
    font-size:14px;
}

/* INPUT */
input[type=text],
input[type=password]{
    width:100%;
    padding:12px;
    border-radius:10px;
    border:1px solid rgba(0,255,255,0.3);
    background:transparent;
    color:#e0f7ff;
    transition:0.3s;
}

input::placeholder{
    color:#7dd3fc;
}

input:focus{
    outline:none;
    border-color:#00ffff;
    box-shadow:0 0 10px #00ffff;
}

/* ===== BUTTON WRAPPER (KEY FIX) ===== */
.button-group{
    display:flex;
    justify-content:center;   /* ✅ center */
    gap:15px;                 /* ✅ spacing between buttons */
    margin-top:15px;
}

/* BUTTON */
.btn{
    padding:10px 20px;
    border-radius:10px;
    border:1px solid #00ffff;
    background:transparent;
    color:#00ffff;
    cursor:pointer;
    transition:0.3s;
    font-size:14px;
}

.btn:hover{
    background:#00ffff;
    color:#020617;
    box-shadow:0 0 12px #00ffff;
}

/* LINKS */
.links{
    text-align:center;
    margin-top:20px;
}

.link-btn{
    display:inline-block;
    margin:6px;
    padding:8px 16px;
    border-radius:10px;
    border:1px solid #00ffff;
    color:#00ffff;
    text-decoration:none;
    transition:0.3s;
    font-size:13px;
}

.link-btn:hover{
    background:#00ffff;
    color:#020617;
}

</style>
</head>

<body>

<div class="container">

<h2>Login</h2>

<form action="login" method="post">

<%
    if(request.getAttribute("message") != null){
%>
    <div class="message">
        <%= request.getAttribute("message") %>
    </div>
<%
    }
%>

<table>

<tr>
<td>Username</td>
<td><input type="text" name="username" placeholder="Enter username" required></td>
</tr>

<tr>
<td>Password</td>
<td><input type="password" name="password" placeholder="Enter password" required></td>
</tr>

</table>

<!-- ✅ FIXED BUTTON ALIGNMENT -->
<div class="button-group">
    <input type="submit" value="Login" class="btn">
    <input type="reset" value="Reset" class="btn">
</div>

</form>

<div class="links">
<a href="/register" class="link-btn">New User Sign-Up</a>
<a href="/forgetpassword" class="link-btn">Forgot Password</a>
</div>

</div>

</body>
</html>