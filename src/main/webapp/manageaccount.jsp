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

        <div class="table__row">
            <div class="table__cell">sss</div>
            <div class="table__cell">sssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</div>
            <div class="table__cell">sssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</div>
            <div class="table__cell">sss</div>
            <div class="table__cell align-center">sss</div>
            <div class="table__cell align-center">
                <div class="role role-2">
                    Staff
                    <form action="" class="set-role" method="post">
                        <input type="radio" id="op-1" name="role" value="1">
                        <input type="radio" id="op-2" name="role" value="2">
                        <input type="radio" id="op-3" name="role" value="3">
                        <button type="submit" class="option">
                            <label for="op-1">
                                <p class="op-1">Admin</p>
                            </label>
                        </button>
                        <button type="submit" class="option">
                            <label for="op-2">
                                <p class="op-2">Staff</p>
                            </label>
                        </button>
                        <button type="submit" class="option">
                            <label for="op-3">
                                <p class="op-3">User</p>
                            </label>
                        </button>
                    </form>
                </div>
            </div>
            <div class="table__cell">sss</div>
            <div class="table__cell align-center">
                <a href="" class="badge badge-active" title="Change status">Active</a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>