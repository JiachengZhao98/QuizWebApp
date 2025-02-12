<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="includes/header.jsp" %>
<html>
<head>
    <title>Contact Us</title>
</head>
<body>
<h1>Contact Us</h1>
<c:if test="${not empty msg}">
    <p style="color:green;">${msg}</p>
</c:if>
<form action="${pageContext.request.contextPath}/contactSubmit" method="post">
    Subject: <input type="text" name="subject" required/><br>
    Email: <input type="email" name="email" required/><br>
    Message:<br>
    <textarea name="message" rows="5" cols="30" required></textarea><br>
    <input type="submit" value="Send"/>
</form>
</body>
</html>
