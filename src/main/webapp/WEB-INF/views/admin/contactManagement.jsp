<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Contact Us Management</title>
</head>
<body>
    <h1>Contact Us Management</h1>
    <table border="1">
        <tr>
            <th>Subject</th>
            <th>Email</th>
            <th>Time</th>
            <th>Message</th>
        </tr>
        <c:forEach var="contact" items="${contacts}">
            <tr>
                <td>${contact.subject}</td>
                <td>${contact.email}</td>
                <td>${contact.time}</td>
                <td>${contact.message}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
