<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management</title>
</head>
<body>
    <h1>User Management</h1>
    <table border="1">
        <tr>
            <th>Full Name</th>
            <th>Email</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.status}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin/users/updateStatus" method="post" style="display:inline;">
                        <input type="hidden" name="userId" value="${user.id}"/>
                        <c:choose>
                            <c:when test="${user.status == 'active'}">
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
