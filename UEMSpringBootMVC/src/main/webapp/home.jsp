<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.capgemini.training.entity.Employee" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Dashboard</title>

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

/* ===== MAIN CONTAINER ===== */
.container {
    position: relative;
    z-index: 1;
    width: 95%;
    max-width: 1200px;
    margin: 40px auto;
    padding: 30px;
    background: rgba(2,6,23,0.9);
    border-radius: 18px;
    border: 1px solid rgba(0,255,255,0.2);
    box-shadow: 0 0 30px rgba(0,255,255,0.1);
}

/* ===== HEADER ===== */
.header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 25px;
}

.header h2 {
    font-weight: 600;
    color: #00ffff;
}

/* ADD BUTTON */
.btn {
    padding: 10px 18px;
    border-radius: 10px;
    border: 1px solid #00ffff;
    color: #00ffff;
    text-decoration: none;
    transition: 0.3s;
    font-size: 14px;
}

.btn:hover {
    background: #00ffff;
    color: #020617;
    box-shadow: 0 0 12px #00ffff;
}

/* ===== TOAST MESSAGE ===== */
.toast {
    text-align: center;
    margin-bottom: 20px;
    padding: 12px;
    border-radius: 8px;
    background: rgba(0,255,150,0.1);
    border: 1px solid rgba(0,255,150,0.4);
    color: #00ffae;
    animation: fadeOut 4s forwards;
}

/* ===== TABLE ===== */
table {
    width: 100%;
    border-collapse: collapse;
    border-radius: 12px;
    overflow: hidden;
}

/* HEADER */
th {
    background: rgba(0,255,255,0.15);
    padding: 14px;
    font-weight: 600;
    color: #00ffff;
}

/* DATA */
td {
    padding: 12px;
    text-align: center;
    border-bottom: 1px solid rgba(0,255,255,0.15);
}

/* ROW EFFECT */
tr:hover {
    background: rgba(0,255,255,0.08);
}

/* EMPTY */
.no-data {
    padding: 20px;
    color: #ff4d4d;
    font-weight: bold;
}

/* ===== ACTION BUTTON ===== */
.action-btn {
    padding: 6px 12px;
    border-radius: 8px;
    border: 1px solid #00ffff;
    text-decoration: none;
    color: #00ffff;
    font-size: 13px;
    transition: 0.3s;
}

.action-btn:hover {
    background: #00ffff;
    color: #020617;
}

/* ===== ANIMATION ===== */
@keyframes fadeOut {
    0% { opacity: 1; }
    80% { opacity: 1; }
    100% { opacity: 0; }
}

</style>
</head>

<body>

<div class="container">

    <!-- HEADER -->
    <div class="header">
        <h2>Employee Dashboard</h2>
        <a href="addemp" class="btn">+ Add Employee</a>
    </div>

    <!-- MESSAGE -->
    <%
        String msg = (String) request.getAttribute("msg");
        if (msg != null) {
    %>
        <div class="toast"><%= msg %></div>
    <%
        }
    %>

    <%
        List<Employee> listOfEmp = (List<Employee>) request.getAttribute("emplist");
    %>

    <!-- TABLE -->
    <table>
        <tr>
            <th>ID</th>
            <th>EMP CODE</th>
            <th>NAME</th>
            <th>EMAIL</th>
            <th>CONTACT</th>
            <th>CITY</th>
            <th>ACTION</th>
        </tr>

        <%
            if (listOfEmp != null && !listOfEmp.isEmpty()) {
                for (Employee emp : listOfEmp) {
        %>
        <tr>
            <td><%= emp.getId() %></td>
            <td><%= emp.getEmpId() %></td>
            <td><%= emp.getEmpName() %></td>
            <td><%= emp.getEmpEmail() %></td>
            <td><%= emp.getEmpContactNo() %></td>
            <td><%= emp.getEmpCity() %></td>
            <td>
                <a href="viewemp?id=<%= emp.getId() %>" class="action-btn">View</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="7" class="no-data">
                🚫 No Employees Found
            </td>
        </tr>
        <%
            }
        %>

    </table>

</div>

</body>
</html>