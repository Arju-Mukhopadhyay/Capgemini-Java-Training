<%@ page import="com.capgemini.training.entity.Employee" %>

<%
    Employee emp = (Employee) request.getAttribute("emp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>

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
    width: 500px;
    padding: 35px;
    background: rgba(2,6,23,0.9);
    border-radius: 18px;
    border: 1px solid rgba(0,255,255,0.25);
    box-shadow: 0 0 25px rgba(0,255,255,0.15);
}

/* ===== TITLE ===== */
h2 {
    text-align: center;
    margin-bottom: 25px;
    color: #00ffff;
    font-weight: 600;
    letter-spacing: 1px;
}

/* ===== TABLE ===== */
table {
    width: 100%;
    border-collapse: collapse;
}

td {
    padding: 12px;
    border-bottom: 1px solid rgba(0,255,255,0.15);
}

/* LABEL COLUMN */
td:first-child {
    color: #7dd3fc;
    font-weight: 500;
    width: 40%;
}

/* VALUE COLUMN */
td:last-child {
    color: #e0f7ff;
}

/* ===== ACTION BUTTONS ===== */
.actions {
    display: flex;
    justify-content: center;
    gap: 12px;
    margin-top: 25px;
}

/* ===== BUTTON ===== */
.btn {
    padding: 10px 18px;
    border-radius: 10px;
    border: 1px solid #00ffff;
    text-decoration: none;
    color: #00ffff;
    font-size: 14px;
    transition: 0.3s;
    cursor: pointer;
    background: transparent;
}

/* SAME HOVER AS EDIT PAGE */
.btn:hover {
    background: #00ffff;
    color: #020617;
    box-shadow: 0 0 12px #00ffff;
}

</style>

<script>
// ✅ DELETE CONFIRMATION (UNCHANGED)
function confirmDelete(id) {
    if(confirm("Are you sure you want to delete this employee?")) {
        window.location.href = "deleteemp?id=" + id;
    }
}
</script>

</head>

<body>

<div class="container">

<h2>Employee Details</h2>

<table>
<tr><td>ID</td><td><%= emp.getId() %></td></tr>
<tr><td>EMP CODE</td><td><%= emp.getEmpId() %></td></tr>
<tr><td>NAME</td><td><%= emp.getEmpName() %></td></tr>
<tr><td>EMAIL</td><td><%= emp.getEmpEmail() %></td></tr>
<tr><td>CONTACT</td><td><%= emp.getEmpContactNo() %></td></tr>
<tr><td>CITY</td><td><%= emp.getEmpCity() %></td></tr>
</table>

<div class="actions">
    <a href="editemp?id=<%= emp.getId() %>" class="btn">Update</a>

    <!-- DELETE (NOW SAME STYLE) -->
    <button onclick="confirmDelete(<%= emp.getId() %>)" class="btn">
        Delete
    </button>

    <a href="allemp" class="btn">Back</a>
</div>

</div>

</body>
</html>