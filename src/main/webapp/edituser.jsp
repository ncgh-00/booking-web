<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="css/form-s.css">
</head>
<body>
<div class="layout">
    <div class="container">
        <h3 class="heading">Edit User</h3>
        <form action="EditUser?id=${sessionScope.Account.UID}" class="form" method="post">
            <div class="input">
                <input type="text" class="input-box" placeholder="Full name (Optional)" name="name">
            </div>

            <div class="input">
                <input type="tel" class="input-box" placeholder="Phone number (Optional)" name="phone">
            </div>

            <div class="input">
                <input type="tel" class="input-box" placeholder="Email (Optional)" name="email">
            </div>

            <div class="input-pas">
                <input type="password" class="input-box password" placeholder="Password (Optional)" name="pass">
            </div>

            <div class="input-pas">
                <input type="password" class="input-box password" placeholder="Repeat password" name="repass" >
                <i class='bx bx-hide eye-icon'></i>
            </div>

            <c:if test="${error != null}">
                <div class="field-text-error">
                    <p>${error}</p>
                </div>
            </c:if>
            <input type="submit" value="Edit" class="btn">
        </form>
    </div>
</div>
<%--hi--%>
<script src="js/form.js"></script>
</body>
</html>