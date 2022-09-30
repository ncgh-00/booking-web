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
    <link rel="stylesheet" href="./css/form.css">
</head>
<body>
<div class="layout">
    <div class="container">
        <h3 class="heading">Login</h3>
        <form action="" class="form">
            <div class="input">
                <input type="text" class="input-box" placeholder="User name" required>
            </div>
            <div class="input-pas">
                <input type="password" class="input-box password" placeholder="Password" required>
                <i class='bx bx-hide eye-icon'></i>
            </div>
            <div class="form-link">
                <a href="" class="forgot-pas-link">Forgot password?</a>
            </div>
            <input type="submit" value="Login" class="btn">
        </form>
        <div class="form-link">
            <span>Don't have an account? <a href="register.jsp" class="signup-link">Signup</a></span>
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

<script src="./js/form.js"></script>
</body>
</html>