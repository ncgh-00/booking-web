<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/dashboard.css">
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="menu">
    <ul class="menu__bar">
        <a class="menu__item" href="">
            <li>Hotel Management</li>
        </a>
        <a class="menu__item selected" href="">
            <li>Account Management</li>
        </a>
        <a class="menu__item" href="">
            <li>statitic</li>
        </a>
    </ul>
</div>

<div class="content">
    <div class="nav">
        <a href="" class="btn"><i class="add-icon fa-solid fa-circle-plus"></i>Add</a>
        <form action="" class="search">
            <input type="text" class="search__bar" id="search-bar" placeholder="Search here...">
        </form>
    </div>
    <div class="table">
        <div class="table__head">
            <div class="table__cell header__table">Full Name</div>
            <div class="table__cell header__table">Email</div>
            <div class="table__cell header__table">Phone</div>
            <div class="table__cell header__table">User Name</div>
            <div class="table__cell header__table">Password</div>
            <div class="table__cell header__table">Role</div>
            <div class="table__cell header__table">Hotel Manage</div>
            <div class="table__cell header__table">Status</div>
        </div>
        <c:forEach items="${ListA}" var="o">
            <div class="table__row">
                <div class="table__cell" data-label="Full Name">${o.fullname}</div>
                <div class="table__cell" data-label="Email">${o.email}</div>
                <div class="table__cell" data-label="Phone">${o.phone}</div>
                <div class="table__cell" data-label="User Name">${o.username}</div>
                <div class="table__cell align-center" data-label="Password">${o.hashPassword}</div>
                <div class="table__cell align-center">
                    <div class="role
                    <c:if test="${o.roleID == 1}">role-1</c:if>
                    <c:if test="${o.roleID == 2}">role-2</c:if>
                    <c:if test="${o.roleID == 3}">role-3</c:if>
                ">
                            ${o.roleName}
                        <div action="EditRole?id=${o.UID}" class="set-role">
                            <a href="EditRole?id=${o.UID}&role=1" class="option"><p class="op-1">Admin</p></a>
                            <a href="EditRole?id=${o.UID}&role=2" class="option"><p class="op-2">Staff</p></a>
                            <a href="EditRole?id=${o.UID}&role=3" class="option"><p class="op-3">User</p></a>
                        </div>
                    </div>
                </div>
                <div class="table__cell">${o.hotelManage}</div>
                <div class="table__cell align-center">
                    <a href="" class="badge badge-active" title="Change status">Active</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>