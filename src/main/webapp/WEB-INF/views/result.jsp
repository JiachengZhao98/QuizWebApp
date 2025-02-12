<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quiz Result</title>
    <style>
        table { border-collapse: collapse; }
        table, th, td { border: 1px solid black; padding: 8px; }
        ul { margin: 0; padding-left: 20px; }
    </style>
</head>
<body>
    <h1>Quiz Result</h1>
    <p><strong>Quiz Name:</strong> ${quizName}</p>
    <p><strong>User:</strong> ${userFullName}</p>
    <p><strong>Start Time:</strong> ${startTime}</p>
    <p><strong>End Time:</strong> ${endTime}</p>
    <p><strong>Score:</strong> ${correctCount} out of ${totalQuestions}</p>

    <h2>Question Details</h2>
    <table>
        <tr>
            <th>Question &amp; Choices</th>
            <th>Your Answer</th>
            <th>Correct Answer</th>
        </tr>
        <c:forEach var="entry" items="${questionResults}">
            <tr>
                <td>
                    <strong>${entry.value.questionText}</strong><br>
                    <ul>
                        <li>A: ${entry.value.optionA}</li>
                        <li>B: ${entry.value.optionB}</li>
                        <li>C: ${entry.value.optionC}</li>
                        <li>D: ${entry.value.optionD}</li>
                    </ul>
                </td>
                <td>${entry.value.userAnswer}</td>
                <td>${entry.value.correctAnswer}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
