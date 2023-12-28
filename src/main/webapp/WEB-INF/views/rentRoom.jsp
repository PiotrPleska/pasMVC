<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="pas.mvc.pasmvc.model.Room" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Create User</title>
</head>
<body>
<h1>RENT</h1>

<%
    String user = (String) request.getAttribute("user");
    List<Room> rooms = (List<Room>) request.getAttribute("rooms");
%>

<form action="${pageContext.request.contextPath}/mvc/sth/rent" method="post">
    <label for="user">User ID:</label>
    <input type="text" id="user" name="user" value="<%= user %>" readonly>
    <label for="rentStartDate">Rent Start Date:</label>
    <input type="datetime-local" id="rentStartDate" name="rentStartDate" required>
    <label for="roomNumber">Select Room:</label>
    <select id="roomNumber" name="roomNumber">
        <%
            for (Room room : rooms) {
        %>
        <option value="<%= room.getRoomNumber() %>"><%= room.getRoomNumber() %></option>
        <%
            }
        %>
    </select>

    <button type="submit">Submit</button>
</form>
</body>
</html>
