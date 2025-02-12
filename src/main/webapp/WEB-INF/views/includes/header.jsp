<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="global-nav" style="background-color: #eee; padding: 10px;">
    <c:if test="${not empty sessionScope.user}">
        <a href="${pageContext.request.contextPath}/home">Home</a> |
    </c:if>
    <!-- Contact Us link should always appear -->
    <a href="${pageContext.request.contextPath}/contact">Contact Us</a> |
    <c:choose>
        <c:when test="${empty sessionScope.user}">
            <a href="${pageContext.request.contextPath}/login">Login</a> |
            <a href="${pageContext.request.contextPath}/register">Register</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </c:otherwise>
    </c:choose>
</div>
<hr>
