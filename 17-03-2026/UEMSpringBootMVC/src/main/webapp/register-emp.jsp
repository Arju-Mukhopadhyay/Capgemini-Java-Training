<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>

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
    width: 440px;
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

/* INPUT GROUP */
.input-group {
    margin-bottom: 16px;
}

label {
    display: block;
    margin-bottom: 6px;
    font-size: 14px;
    color: #a5f3fc;
}

/* INPUT */
input {
    width: 100%;
    padding: 12px;
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
    padding: 11px 26px;
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

/* BACK LINK */
.actions {
    text-align: center;
    margin-top: 20px;
}

.link-btn {
    display: inline-block;
    padding: 8px 18px;
    border-radius: 10px;
    border: 1px solid #00ffff;
    color: #00ffff;
    text-decoration: none;
    transition: 0.3s;
    font-size: 13px;
}

.link-btn:hover {
    background: #00ffff;
    color: #020617;
}

</style>

</head>

<body>

<div class="container">

    <h2>Add Employee</h2>

    <form action="addemp" method="post">

        <div class="input-group">
            <label>Employee ID</label>
            <input type="text" name="empId" required>
        </div>

        <div class="input-group">
            <label>Name</label>
            <input type="text" name="empName" required>
        </div>

        <div class="input-group">
            <label>Email</label>
            <input type="email" name="empEmail" required>
        </div>

        <div class="input-group">
            <label>Contact Number</label>
            <input type="text" name="empContactNo" required>
        </div>

        <div class="input-group">
            <label>City</label>
            <input type="text" name="empCity" required>
        </div>

        <!-- ✅ CENTERED BUTTON -->
        <div class="button-group">
            <button type="submit" class="btn">Add Employee</button>
        </div>

    </form>

    <div class="actions">
        <a href="allemp" class="link-btn">Back</a>
    </div>

</div>

</body>
</html>