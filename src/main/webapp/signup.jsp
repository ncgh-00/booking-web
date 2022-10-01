<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="css/form-l.css">
</head>
<body>
<div class="layout">
    <div class="container">
        <h3 class="heading">Sign Up</h3>
        <form action="SignUp" class="form" method="post">
            <div class="input">
                <input type="text" class="input-box" placeholder="Full Name" name="name" required>
            </div>

            <div class="input">
                <input type="email" class="input-box" placeholder="Email" name="email" required>
            </div>

            <div class="input">
                <input type="tel" class="input-box" placeholder="Phone Number" name="phone" required>
            </div>

            <div class="input">
                <input type="text" class="input-box" placeholder="User Name" name="user_name" required>
            </div>

            <div class="input-pas">
                <input type="password" class="input-box password" placeholder="Password" name="pass" required>
                <i class='bx bx-hide eye-icon'></i>
            </div>

            <div class="input-pas">
                <input type="password" class="input-box password" placeholder="Repeat Password" name="repass" required>
                <i class='bx bx-hide eye-icon'></i>
            </div>

            <c:if test="${errorSignup != null}">
                <div class="field-text-error">
                    <p>${errorSignup}</p>
                </div>
            </c:if>
            <input type="submit" value="Sign Up" class="btn">
            <input type="hidden" value="<%=request.getParameter("page")%>" name="page">
            <input type="hidden" value="<%=request.getParameter("id_hotel")%>" name="id_hotel">
        </form>
        <div class="form-link">
            <span>Already have an account? <a href="login.jsp?page=<%=request.getParameter("page")%>&&id_hotel=<%=request.getParameter("id_hotel")%>" class="signup-link">Login</a></span>
        </div>
        <div class="line"></div>
        <div class="media-options">
            <a href="#" class="field google">
                <img src="images/google.png" alt="" class="google-img">
                <span>Login with Google</span>
            </a>
        </div>
    </div>
</div>

<script src="js/form.js"></script>
</body>
</html>