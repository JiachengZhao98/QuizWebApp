<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${quizName}</title>
    <style>
        .question { margin-bottom: 20px; }
    </style>
</head>
<body>
    <h1>${quizName}</h1>
    <form action="${pageContext.request.contextPath}/submitQuiz" method="post">
        <c:forEach var="question" items="${questions}" varStatus="status">
            <div class="question">
                <!-- Include the question ID as a hidden field or in the name attribute -->
                <p><strong>Question ${status.index + 1}:</strong> ${question.questionText}</p>
                <!-- The name "q{questionId}" is used so we can later retrieve the question ID -->
                <label>
                    <input type="radio" name="q${question.id}" value="A" required/> ${question.optionA}
                </label><br>
                <label>
                    <input type="radio" name="q${question.id}" value="B"/> ${question.optionB}
                </label><br>
                <label>
                    <input type="radio" name="q${question.id}" value="C"/> ${question.optionC}
                </label><br>
                <label>
                    <input type="radio" name="q${question.id}" value="D"/> ${question.optionD}
                </label><br>
            </div>
        </c:forEach>
        <input type="hidden" name="categoryId" value="${categoryId}" />
        <input type="submit" value="Submit Quiz" />
    </form>
</body>
</html>
