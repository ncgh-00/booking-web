<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="icon" type="image/x-icon" href="./images/logo.svg">
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="css/form-s.css">
</head>
<body>
<div class="layout">
    <div class="container">
        <h3 class="heading">Login</h3>
        <form action="Login" class="form" method="post">
            <div class="input">
                <input type="text" class="input-box" placeholder="User name" name="username" required>
            </div>
            <div class="input-pas">
                <input type="password" class="input-box password" placeholder="Password" name="password" required>
                <i class='bx bx-hide eye-icon'></i>
            </div>

            <c:if test="${error != null}">
                <div class="field-text-error">
                    <p>${error}</p>
                </div>
            </c:if>

            <div class="form-link">
                <a href="" class="forgot-pas-link">Forgot password?</a>
            </div>
            <input type="submit" value="Login" class="btn">
            <input type="hidden" value="<%=request.getParameter("page")%>" name="page">
            <input type="hidden" value="<%=request.getParameter("id")%>" name="id">
        </form>
        <div class="form-link">
            <span>Don't have an account? <a
                    href="signup.jsp?page=<%=request.getParameter("page")%>&&id=<%=request.getParameter("id")%>"
                    class="signup-link">Signup</a></span>
        </div>
        <div class="line"></div>
        <div class="media-options">
            <a href="https://accounts.google.com/o/oauth2/auth?scope=openid%20profile%20email&redirect_uri=http://localhost:8080/Trividi_Project/LoginGoogle&response_type=code
    &client_id=938297631263-5icnubscvafbg7tdpch94v3ppdebq7cd.apps.googleusercontent.com&approval_prompt=force" class="field google">
                <img src="images/google.png" alt="" class="google-img">
                <span>Login with Google</span>
            </a>
        </div>
    </div>
</div>
<script src="js/form.js"></script>
</body>
</html>