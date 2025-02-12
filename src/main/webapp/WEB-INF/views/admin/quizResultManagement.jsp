<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quiz Result Management</title>
</head>
<body>
    <h1>Quiz Result Management</h1>

    <!-- Filter form -->
    <form method="get" action="${pageContext.request.contextPath}/admin/quizResults">
        Category: <input type="text" name="category" />
        User: <input type="text" name="user" />
        <input type="submit" value="Filter" />
    </form>

    <table border="1">
        <tr>
            <th>Taken Time</th>
            <th>Category</th>
            <th>User Full Name</th>
            <th>No. of Questions</th>
            <th>Score</th>
        </tr>
        <c:forEach var="result" items="${results}">
            <tr>
                <td><a href="${pageContext.request.contextPath}/admin/quizResult/${result.id}">${result.takenTime}</a></td>
                <td>${result.category}</td>
                <td>${result.userFullName}</td>
                <td>${result.numQuestions}</td>
                <td>${result.score}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
