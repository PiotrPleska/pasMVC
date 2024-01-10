<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create User</title>
</head>
<body>
<h1>Create User</h1>
<form action="${pageContext.request.contextPath}/mvc/sth/user" method="post" enctype="application/x-www-form-urlencoded">
    <label for="login">Login:</label>
    <input type="text" id="login" name="login" required>
    <span style="color: red;"><%= (request.getAttribute("loginError") != null) ? request.getAttribute("loginError") : ""%></span>


    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    <span style="color: red;"><%= (request.getAttribute("passwordError") != null) ? request.getAttribute("passwordError") : "" %></span>


    <label for="personalId">Personal ID:</label>
    <input type="text" id="personalId" name="personalId" required>
    <span style="color: red;"><%= (request.getAttribute("personalIdError") != null) ? request.getAttribute("personalIdError") : "" %></span>


    <button type="submit">Create User</button>
</form>
</body>
</html>
