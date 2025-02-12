<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Question Management</title>
</head>
<body>
    <h1>Question Management</h1>
    <a href="${pageContext.request.contextPath}/admin/question/add">Add New Question</a>
    <table border="1">
        <tr>
            <th>Category</th>
            <th>Question</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="q" items="${questions}">
            <tr>
                <td>${q.categoryId}</td>
                <td>${q.questionText}</td>
                <td>${q.status}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/question/edit/${q.id}">Edit</a> |
                    <form action="${pageContext.request.contextPath}/admin/questions/updateStatus" method="post" style="display:inline;">
                        <input type="hidden" name="questionId" value="${q.id}"/>
                        <c:choose>
                            <c:when test="${q.status == 'active'}">
                                <input type="hidden" name="status" value="suspended"/>
                                <input type="submit" value="Suspend"/>
                            </c:when>
                            <c:otherwise>
                                <input type="hidden" name="status" value="active"/>
                                <input type="submit" value="Activate"/>
                            </c:otherwise>
                        </c:choose>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
