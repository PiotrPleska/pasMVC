<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="pas.mvc.pasmvc.model.ClientAccount" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Create User</title>
</head>
<body>
<h1>RENT</h1>

<%
    ClientAccount user = (ClientAccount) request.getAttribute("user");
    // Modify the type and name according to your actual object structure
//    List<String> rooms = (List<String>) request.getAttribute("rooms");
%>

<form action="${pageContext.request.contextPath}/rent" method="post">
    <label for="rentStartDate">Rent Start Date:</label>
    <input type="date" id="rentStartDate" name="rentStartDate" required>

    <label for="roomId">Select Room:</label>
    <select id="roomId" name="roomId" required>
<%--        <% for (String room : rooms) { %>--%>
<%--        <option value="<%= room %>"><%= room %></option>--%>
<%--        <% } %>--%>
        <option value="1">Room 1</option>
        <option value="2">Room 2</option>
        <option value="3">Room 3</option>
        <option value="4">Room 4</option>
    </select>

    <button type="submit">Submit</button>
</form>
</body>
</html>
