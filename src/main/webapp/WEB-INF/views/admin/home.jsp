<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %>
<html>
<head>
  <title>Admin Home</title>
  <style>
    /* Simple styling for the admin navigation bar */
    .admin-navbar {
      list-style: none;
      padding: 0;
      margin: 0;
      background-color: #333;
    }
    .admin-navbar li {
      display: inline-block;
    }
    .admin-navbar li a {
      display: block;
      padding: 14px 20px;
      color: #fff;
      text-decoration: none;
    }
    .admin-navbar li a:hover {
      background-color: #575757;
    }
    .container {
      margin: 20px;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>Welcome to the Admin Home Page</h1>

  <!-- Admin Navigation Bar -->
  <ul class="admin-navbar">
    <li><a href="${pageContext.request.contextPath}/admin/users">User Management</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/quizResults">Quiz Result Management</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/questions">Question Management</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/contacts">Contact Us Management</a></li>
  </ul>

  <p>Use the navigation bar above to manage users, quiz results, questions, and contact messages.</p>
</div>
</body>
</html>
