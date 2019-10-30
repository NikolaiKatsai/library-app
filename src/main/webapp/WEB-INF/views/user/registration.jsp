<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registration" method="post">
    <div class="container">
        <h1 align="center">Registration page</h1>

        <label for="login"><b>Login</b></label>
        <input value="${userName}" type="text" placeholder="Enter login" name="login" required>

        <label for="psw"><b>Password</b></label>
        <input value="${password}" type="password" placeholder="Enter Password" name="psw" required>

        <label for="psw-repeat"><b>Repeat Password</b></label>
        <input value="${repeatPassword}" type="password" placeholder="Repeat Password" name="psw-repeat" required>

        <label for="user_name"><b>Name</b></label>
        <input value="${firstName}" type="text" placeholder="user_name" name="user_name" required>

        <label for="user_surname"><b>Surname</b></label>
        <input value="${lastName}" type="text" placeholder="user_surname" name="user_surname" required>
        <hr>

        <label for="user_email"><b>Email</b></label>
        <input value="${email}" type="text" placeholder="user_email" name="user_email" required>

        <button type="submit">Register</button>
    </div>

    <div>
        <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Sign in</a></p>
    </div>
</form>
</body>
</html>