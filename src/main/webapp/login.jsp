<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
    <!-- CSS -->
    <!-- Boxicons CSS -->
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="./css/form.css">

</head>
<body>
<section class="container forms">
    <div class="form login">
        <div class="form-content">

            <header>Login</header>
            <form action="Login" method="post">
                <div class="field input-field">
                    <input type="username" placeholder="Username" class="input" name="username" required>
                </div>

                <div class="field input-field">
                    <input type="password" placeholder="Password" class="password" name="password" required>
                    <i class='bx bx-hide eye-icon'></i>
                </div>
                <c:if test="${error != null}">
                    <div class="field__text__error">
                        <p>${error}</p>
                    </div>
                </c:if>
                <c:if test="${success != null}">
                    <div class="field__text__signup">
                        <p>${success}</p>
                    </div>
                </c:if>
                <div class="form-link">
                    <a href="form_email.jsp" class="forgot-pass">Forgot password?</a>
                </div>
                <div class="field button-field">
                    <button type="submit">Login</button>
                </div>
                <input type="hidden" value="<%=request.getParameter("page")%>" name="page">
            </form>
            <div class="form-link">
                <span>Don't have an account? <a href="register.jsp" class="link signup-link">Signup</a></span>
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
</section>
<!-- JavaScript -->
<script src="./js/form.js"></script>
</body>
</html>
