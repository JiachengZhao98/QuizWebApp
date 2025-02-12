<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %>
<html>
<head>
    <title>Edit Question</title>
</head>
<body>
<h1>Edit Question</h1>
<form action="${pageContext.request.contextPath}/admin/question/edit" method="post">
    <input type="hidden" name="id" value="${question.id}" />
    Category ID: <input type="number" name="categoryId" value="${question.categoryId}" required /><br>
    Question Text: <textarea name="questionText" required>${question.questionText}</textarea><br>
    Option A: <input type="text" name="optionA" value="${question.optionA}" required /><br>
    Option B: <input type="text" name="optionB" value="${question.optionB}" required /><br>
    Option C: <input type="text" name="optionC" value="${question.optionC}" required /><br>
    Option D: <input type="text" name="optionD" value="${question.optionD}" required /><br>
    Correct Option: <input type="text" name="correctOption" value="${question.correctOption}" required /><br>
    <input type="submit" value="Update Question" />
</form>
</body>
</html>
