<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.capgemini.training.entity.Employee" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Employee Console</title>

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
    width:95%;
    max-width:1100px;
    margin:40px auto;
    padding:30px;
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

/* BUTTON */
.btn{
    padding:10px 18px;
    border-radius:10px;
    border:1px solid #00ffff;
    background:transparent;
    color:#00ffff;
    cursor:pointer;
    transition:0.3s;
    font-size:14px;
    text-decoration:none;
}

.btn:hover{
    background:#00ffff;
    color:#020617;
    box-shadow:0 0 12px #00ffff;
}

/* SEARCH */
.search-box{
    display:flex;
    justify-content:center;
    gap:10px;
    margin-bottom:20px;
}

.search-box input{
    padding:12px;
    width:300px;
    border-radius:10px;
    border:1px solid rgba(0,255,255,0.3);
    background:transparent;
    color:#e0f7ff;
}

.search-box input::placeholder{
    color:#7dd3fc;
}

.search-box input:focus{
    outline:none;
    border-color:#00ffff;
    box-shadow:0 0 10px #00ffff;
}

/* TABLE */
table{
    width:100%;
    border-collapse:collapse;
    border-radius:12px;
    overflow:hidden;
}

th{
    background:rgba(0,255,255,0.15);
    padding:14px;
    font-weight:600;
    color:#00ffff;
}

td{
    padding:12px;
    text-align:center;
    border-bottom:1px solid rgba(0,255,255,0.15);
}

tr:hover{
    background:rgba(0,255,255,0.08);
}

/* MESSAGE */
.message{
    text-align:center;
    margin-bottom:15px;
    color:#00ff88;
    font-weight:bold;
}

/* NO DATA */
.no-data{
    padding:20px;
    color:#ff4d4d;
    font-weight:bold;
}

</style>

</head>
<body>

<div class="container">

    <%-- Message Section --%>
    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
        <p class="message"><%= message %></p>
    <%
        }
    %>

    <a href="addemp" class="btn">+ Add New Employee</a>

    <h2>View Employee Console</h2>

    <%
        List<Employee> listOfEmp = (List<Employee>) request.getAttribute("emplist");
    %>

    <!-- SEARCH -->
    <form action="searchemp" method="get" class="search-box">
        <input type="text" name="keyword" placeholder="Search by ID, Name or Email">
        <button type="submit" class="btn">Search</button>
    </form>

    <!-- TABLE -->
    <table>
        <tr>
            <th>ID</th>
            <th>EMP CODE</th>
            <th>NAME</th>
            <th>EMAIL</th>
            <th>CONTACT</th>
            <th>CITY</th>
            <th>ACTIONS</th>
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
                <a href="viewemp?id=<%= emp.getId() %>" class="btn">View</a>
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