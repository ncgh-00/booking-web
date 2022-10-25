<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Account</title>
    <link rel="icon" type="image/x-icon" href="./images/logo.svg">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/dashboard.css">
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="menu">
    <ul class="menu__bar">
        <a class="menu__item" href="LoadHotels">
            <li>Hotel Management</li>
        </a>
        <a class="menu__item selected" href="#">
            <li>Account Management</li>
        </a>
        <a class="menu__item" href="LoadStatistic">
            <li>statistic</li>
        </a>
    </ul>
</div>

<div class="content">
    <div class="nav">
        <a href="AddNewAccount" class="btn"><i class="add-icon fa-solid fa-circle-plus"></i>Add new account</a>
        <form action="SearchAccount" class="search" method="post">
            <input oninput="searchAccount(this)" type="text" name="text" class="search__bar" id="search-bar"
                   placeholder="Search here (username) ...">
        </form>
    </div>
    <div id="row-table" class="table">
        <div class="table__head">
            <div class="table__cell header__table">Full Name</div>
            <div class="table__cell header__table">Email</div>
            <div class="table__cell header__table">Phone</div>
            <div class="table__cell header__table">User Name</div>
            <div class="table__cell header__table">Role</div>
            <div class="table__cell header__table">Hotel Manage</div>
            <div class="table__cell header__table">Status</div>
        </div>
        <c:forEach items="${ListA}" var="o">
            <div class="table__row">
                <div class="table__cell" data-label="Full Name">${o.fullname}</div>
                <div class="table__cell align-center" data-label="Email">${o.email}</div>
                <div class="table__cell align-center" data-label="Phone">${o.phone}</div>
                <div class="table__cell align-center" data-label="User Name">${o.username}</div>
                <div class="table__cell align-center">
                    <div class="role
                    <c:if test="${o.roleID == 1}">role-1</c:if>
                    <c:if test="${o.roleID == 2}">role-2</c:if>
                    <c:if test="${o.roleID == 3}">role-3</c:if>
                ">
                            ${o.roleName}
                        <div class="set-role">
                            <a href="EditRole?id=${o.UID}&role=1" class="option"><p class="op-1">Admin</p></a>
                            <a href="EditRole?id=${o.UID}&role=2" class="option"><p class="op-2">Staff</p></a>
                            <a href="EditRole?id=${o.UID}&role=3" class="option"><p class="op-3">User</p></a>
                        </div>
                    </div>
                </div>
                <c:if test="${o.roleID == 2 && o.hotelManage == null }">
                <div class="table__cell align-center"><a href="AddHotelForStaff?staffid=${o.UID}" class="add-btn">Add Hotel</a></div>
                </c:if>
                <c:if test="${o.roleID == 2 && o.hotelManage != null }">
                    <div class="table__cell align-center">${o.hotelManage}</div>
                </c:if>
                <c:if test="${o.roleID != 2}">
                    <div class="table__cell align-center">No</div>
                </c:if>

                <c:if test="${o.status == true}">
                    <div class="table__cell align-center" data-label="Status">
                        <a title="Change status"
                           href="ActivateAccounts?uid=${o.UID}&check=${o.status}&page=LoadAccounts"
                           class="badge badge-active">active</a>
                    </div>
                </c:if>
                <c:if test="${o.status == false}">
                    <div class="table__cell align-center" data-label="Status">
                        <a title="Change status"
                           href="ActivateAccounts?uid=${o.UID}&check=${o.status}&page=LoadAccounts"
                           class="badge badge-inactive">inactive</a>
                    </div>
                </c:if>

            </div>
        </c:forEach>
    </div>
</div>

<div class="noti close-btn ${show==1?"open":""}">
    <div class="noti-container">
        <div class="noti-heading">
            <h3 class="heading">New Account</h3>
            <div class="close-btn"><i class="fas fa-times"></i></div>
        </div>
        <div class="noti-body">
            <span class="message mt-12"> New account has been created: </span>
            <p><span class="label mt-12">Username:</span>${requestScope.username}</p>
            <p><span class="label">Password: </span>${requestScope.pass}</p>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
        integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<script>
    function searchAccount(acc) {
        var txtSearch = acc.value;
        $.ajax({
            url: '/Trividi_Project/SearchAccount',
            type: 'post',
            data: {
                text: txtSearch
            },
            success: function (data) {
                var row = document.getElementById("row-table")
                row.innerHTML = data;
            },
            error: function () {
                alert("error");
            }
        });

    }
</script>

<script src="./js/header.js"></script>
<script src="./js/noti.js"></script>
</body>

</html>