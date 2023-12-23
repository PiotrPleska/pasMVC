<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="pas.mvc.pasmvc.model.ClientAccount" %>
<%@ page import="java.util.List" %>
<%@ page import="pas.mvc.pasmvc.model.Room" %>
<%@ page import="java.util.Collections" %>
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
    // Ensure that rooms is never null; if null, provide an empty list
    List<Room> rooms = (List<Room>) request.getAttribute("rooms");
    if (rooms == null) {
        rooms = Collections.emptyList();
    }
%>

<form action="${pageContext.request.contextPath}/rent" method="post">
    <label for="rentStartDate">Rent Start Date:</label>
    <input type="date" id="rentStartDate" name="rentStartDate" required>

    <label for="roomId">Select Room:</label>
    <select id="roomId" name="roomId" required>
        <% if (!rooms.isEmpty()) { %>
        <% for (Room room : rooms) { %>
        <option value="<%= room.getRoomNumber() %>"><%= room.getRoomNumber() %></option>
        <% } %>
        <% } else { %>
        <option value="" disabled>No rooms available</option>
        <% } %>
    </select>

    <button type="submit">Submit</button>
</form>
</body>
</html>
