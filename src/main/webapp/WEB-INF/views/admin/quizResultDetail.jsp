<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %>
<html>
<head>
    <title>Quiz Result Detail</title>
</head>
<body>
<h1>Quiz Result Detail</h1>
<p><strong>Quiz Result ID:</strong> ${result.id}</p>
<p><strong>User:</strong> ${result.userFullName}</p>
<p><strong>Category:</strong> ${result.category}</p>
<p><strong>Taken Time:</strong> ${result.takenTime}</p>
<p><strong>No. of Questions:</strong> ${result.numQuestions}</p>
<p><strong>Score:</strong> ${result.score}</p>
</body>
</html>
