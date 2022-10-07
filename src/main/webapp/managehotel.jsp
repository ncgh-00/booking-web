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

<a class="nav-link" href="HomeBooking">
<div class="menu">
    <ul class="menu__bar">
        <a class="menu__item selected" href="">
            <li>Hotel Management</li>
        </a>
        <a class="menu__item" href="LoadAccounts">
            <li>Account Management</li>
        </a>
        <a class="menu__item" href="">
            <li>statistic</li>
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
            <div class="table__cell header__table">Hotel's Name</div>
            <div class="table__cell header__table">Description</div>
            <div class="table__cell header__table">Category</div>
            <div class="table__cell header__table">Phone</div>
            <div class="table__cell header__table">Address</div>
            <div class="table__cell header__table">Number Of Star</div>
            <div class="table__cell header__table">City</div>
            <div class="table__cell header__table">Status</div>
            <div class="table__cell header__table">priority</div>
        </div>
        <div class="table__row">
            <div class="table__cell">sss</div>
            <div class="table__cell">sssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</div>
            <div class="table__cell">sssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</div>
            <div class="table__cell">sss</div>
            <div class="table__cell">sss</div>
            <div class="table__cell align-center">sss</div>
            <div class="table__cell align-center">sss</div>
            <div class="table__cell align-center">
                <a href="" class="badge badge-active" title="Change status">Active</a>
            </div>
            <div class="table__cell align-center">
                <div class="priority priority-1">
                    <form action="index.html" class="set-priority" method="post">
                        <input type="radio" id="op-1" name="priority" value="1">
                        <input type="radio" id="op-2" name="priority" value="2">
                        <input type="radio" id="op-3" name="priority" value="3">
                        <input type="radio" id="op-4" name="priority" value="4">
                        <input type="radio" id="op-5" name="priority" value="5">

                        <button type="submit" class="option">
                            <label for="op-1">
                                <p class="op-1">Priority: 1</p>
                            </label>
                        </button>
                        <button type="submit" class="option">
                            <label for="op-2">
                                <p class="op-2">Priority: 2</p>
                            </label>
                        </button>
                        <button type="submit" class="option">
                            <label for="op-3">
                                <p class="op-3">Priority: 3</p>
                            </label>
                        </button>
                        <button type="submit" class="option">
                            <label for="op-4">
                                <p class="op-4">Priority: 4</p>
                            </label>
                        </button>
                        <button type="submit" class="option">
                            <label for="op-5">
                                <p class="op-5">Priority: 5</p>
                            </label>
                        </button>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>