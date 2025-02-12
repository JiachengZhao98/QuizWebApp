<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="includes/header.jsp" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>
    <form action="${pageContext.request.contextPath}/login" method="post">
        Email: <input type="email" name="email" required/><br>
        Password: <input type="password" name="password" required/><br>
        <input type="submit" value="Login"/>
    </form>

    <!-- Registration Link -->
    <p>
        First time user? <a href="${pageContext.request.contextPath}/register">Register here</a>
    </p>
</body>
</html>
