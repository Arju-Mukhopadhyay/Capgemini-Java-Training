<%@ page import="com.capgemini.training.entity.Employee" %>

<%
    Employee emp = (Employee) request.getAttribute("emp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>

<!-- 🔹 GOOGLE FONT -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif:wght@300;400;600&display=swap" rel="stylesheet">

<style>

/* ===== GLOBAL ===== */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Noto Serif', 'Segoe UI', serif;
}

/* ===== BODY ===== */
body {
    background: radial-gradient(circle at center, #0a0f2c, #020617);
    color: #e0f7ff;
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

/* GRID BACKGROUND */
body::before {
    content: "";
    position: fixed;
    width: 100%;
    height: 100%;
    background-image:
        linear-gradient(rgba(0,255,255,0.05) 1px, transparent 1px),
        linear-gradient(90deg, rgba(0,255,255,0.05) 1px, transparent 1px);
    background-size: 40px 40px;
    z-index: 0;
}

/* ===== CARD ===== */
.container {
    position: relative;
    z-index: 1;
    width: 420px;
    padding: 35px;
    background: rgba(2,6,23,0.9);
    border-radius: 18px;
    border: 1px solid rgba(0,255,255,0.25);
    box-shadow: 0 0 25px rgba(0,255,255,0.15);
}

/* TITLE */
h2 {
    text-align: center;
    margin-bottom: 25px;
    color: #00ffff;
    font-weight: 600;
    letter-spacing: 1px;
}

/* FORM */
form {
    display: flex;
    flex-direction: column;
}

/* INPUT */
input[type=text] {
    width: 100%;
    padding: 12px;
    margin-bottom: 14px;
    border-radius: 10px;
    border: 1px solid rgba(0,255,255,0.3);
    background: transparent;
    color: #e0f7ff;
    transition: 0.3s;
}

input::placeholder {
    color: #7dd3fc;
}

input:focus {
    outline: none;
    border-color: #00ffff;
    box-shadow: 0 0 10px #00ffff;
}

/* ===== BUTTON GROUP ===== */
.button-group {
    display: flex;
    justify-content: center;
    margin-top: 10px;
}

/* BUTTON */
.btn {
    padding: 11px 25px;
    border-radius: 10px;
    border: 1px solid #00ffff;
    background: transparent;
    color: #00ffff;
    cursor: pointer;
    transition: 0.3s;
    font-size: 14px;
}

.btn:hover {
    background: #00ffff;
    color: #020617;
    box-shadow: 0 0 12px #00ffff;
}

</style>

</head>

<body>

<div class="container">

<h2>Update Employee</h2>

<form action="updateemp" method="post">

<input type="hidden" name="id" value="<%= emp.getId() %>">

<input type="text" name="empId" value="<%= emp.getEmpId() %>" placeholder="Emp ID">
<input type="text" name="empName" value="<%= emp.getEmpName() %>" placeholder="Name">
<input type="text" name="empEmail" value="<%= emp.getEmpEmail() %>" placeholder="Email">
<input type="text" name="empContactNo" value="<%= emp.getEmpContactNo() %>" placeholder="Contact">
<input type="text" name="empCity" value="<%= emp.getEmpCity() %>" placeholder="City">

<!-- ✅ CENTERED BUTTON -->
<div class="button-group">
    <button type="submit" class="btn">Update Employee</button>
</div>

</form>

</div>

</body>
</html>