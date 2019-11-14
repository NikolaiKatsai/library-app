<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nik
  Date: 04.11.2019
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registration" method="post">
    <div>
        <h1 align="center">Registration page</h1>
        <c:if test="${errorMsg!=null}">
            <p>${errorMsg}</p>
        </c:if>
        <label for="login"><b>Login</b></label>
        <input value="${userDto.username}" type="text" placeholder="Enter login" name="username" id="login" required>

        <label for="psw"><b>Password</b></label>
        <input value="${userDto.password}" type="password" placeholder="Enter Password" name="password" id="psw"
               required>

        <label for="psw-repeat"><b>Repeat Password</b></label>
        <input value="${userDto.repeatPassword}" type="password" placeholder="Repeat Password" name="repeatPassword"
               id="psw-repeat"
               required>

        <label for="user_name"><b>Name</b></label>
        <input value="${userDto.firstName}" type="text" placeholder="user_name" name="firstName" id="user_name"
               required>

        <label for="user_surname"><b>Surname</b></label>
        <input value="${userDto.lastName}" type="text" placeholder="user_surname" name="lastName" id="user_surname"
               required>
        <hr>

        <label for="user_email"><b>Email</b></label>
        <input value="${userDto.email}" type="text" placeholder="user_email" name="email" id="user_email" required>

        <button type="submit">Register</button>
    </div>

    <div>
        <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Sign in</a></p>
    </div>
</form>
</body>
</html>
