<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="includes/header.jsp" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h1>Register</h1>
    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>
    <form action="${pageContext.request.contextPath}/register" method="post">
        Email: <input type="email" name="email" required/><br>
        First Name: <input type="text" name="firstName" required/><br>
        Last Name: <input type="text" name="lastName" required/><br>
        Password: <input type="password" name="password" required/><br>
        <input type="submit" value="Register"/>
    </form>
</body>
</html>
