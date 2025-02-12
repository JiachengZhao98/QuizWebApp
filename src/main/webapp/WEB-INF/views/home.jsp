<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Home</title>
    <style>
        table { border-collapse: collapse; width: 80%; margin: 20px 0; }
        table, th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        ul { list-style: none; padding: 0; }
        ul li { margin-bottom: 8px; }
        .section { margin-bottom: 30px; }
    </style>
</head>
<body>
    <h1>Welcome, ${sessionScope.user.firstName}!</h1>

    <!-- Take Quiz Section -->
    <div class="section">
        <h2>Take a Quiz</h2>
        <p>Select a category below to start a new quiz:</p>
        <ul>
            <li><a href="${pageContext.request.contextPath}/quiz/1?num=5">General Knowledge</a></li>
            <li><a href="${pageContext.request.contextPath}/quiz/2?num=5">Science</a></li>
            <li><a href="${pageContext.request.contextPath}/quiz/3?num=5">History</a></li>
        </ul>
    </div>

    <!-- Recent Quizzes Taken Section -->
    <div class="section">
        <h2>Recent Quizzes Taken</h2>
        <c:choose>
            <c:when test="${empty quizResults}">
                <p>You have not taken any quizzes yet.</p>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <th>Quiz Result ID</th>
                        <th>Category</th>
                        <th>Taken Time</th>
                        <th>Score</th>
                    </tr>
                    <c:forEach var="result" items="${quizResults}">
                        <tr>
                            <td>${result.id}</td>
                            <td>${result.category}</td>
                            <td>${result.takenTime}</td>
                            <td>${result.score} / ${result.numQuestions}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
