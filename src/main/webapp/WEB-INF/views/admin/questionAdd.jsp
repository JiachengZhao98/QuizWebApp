<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %>
<html>
<head>
    <title>Add Question</title>
</head>
<body>
<h1>Add New Question</h1>
<form action="${pageContext.request.contextPath}/admin/question/add" method="post">
    Category ID: <input type="number" name="categoryId" required /><br>
    Question Text: <textarea name="questionText" required></textarea><br>
    Option A: <input type="text" name="optionA" required /><br>
    Option B: <input type="text" name="optionB" required /><br>
    Option C: <input type="text" name="optionC" required /><br>
    Option D: <input type="text" name="optionD" required /><br>
    Correct Option: <input type="text" name="correctOption" required /><br>
    <input type="submit" value="Add Question" />
</form>
</body>
</html>
