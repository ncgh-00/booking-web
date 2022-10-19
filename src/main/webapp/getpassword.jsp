<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Get Password</title>
    <link rel="icon" type="image/x-icon" href="./images/logo.svg">
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="css/form-s.css">
</head>
<body>
<div class="layout">
    <div class="container">
        <h3 class="heading">Get Password</h3>
        <form action="GetPassword" class="form" method="post">
            <div class="input">
                <input type="text" class="input-box" placeholder="Enter Email" name="email" required>
            </div>

            <c:if test="${error != null}">
                <div class="field-text-error">
                    <p>${error}</p>
                </div>
            </c:if>
            <c:if test="${success != null}">
                <div class="field-text-error sucess">
                    <p>${success}</p>
                </div>
            </c:if>
            <input type="submit" value="Send email" class="btn">
            <input type="hidden" value="<%=request.getParameter("page")%>" name="page">
            <input type="hidden" value="<%=request.getParameter("id")%>" name="id">
        </form>
        <div class="form-link">
            <span>Back to <a
                    href="login.jsp?page=<%=request.getParameter("page")%>&&id=<%=request.getParameter("id")%>"
                    class="signup-link">Login</a></span>
        </div>

    </div>
</div>
</body>
</html>