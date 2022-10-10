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
        <a class="menu__item selected" href="#">
            <li>Hotel Management</li>
        </a>
        <a class="menu__item" href="LoadAccounts">
            <li>Account Management</li>
        </a>
        <a class="menu__item" href="LoadStatistic">
            <li>statistic</li>
        </a>
    </ul>
</div>

<div class="content">
    <div class="nav">
        <a href="" class="btn"><i class="add-icon fa-solid fa-circle-plus"></i>Add</a>
        <form action="SearchHotel" class="search" method="post">
            <input type="text" oninput="searchHotel(this)" name="hotelname" class="search__bar" id="search-bar" placeholder="Search here...">
        </form>
    </div>
    <div id="row-table" class="table">
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
        <c:forEach items="${listH}" var="o">
        <div class="table__row">
            <div class="table__cell">${o.name}</div>
            <div class="table__cell">${o.des}</div>
            <div class="table__cell align-center">${o.category}</div>
            <div class="table__cell align-center">${o.phone}</div>
            <div class="table__cell">${o.address}</div>
            <div class="table__cell align-center">${o.star}</div>
            <div class="table__cell align-center">${o.city}</div>
            <c:if test="${o.status == true}">
            <div class="table__cell align-center">
                <a href="ActivateHotel?id=${o.id}&check=${o.status}&page=LoadHotels"
                   class="badge badge-active" title="Change status">Active</a>
            </div>
            </c:if>
            <c:if test="${o.status == false}">
                <div class="table__cell align-center">
                    <a href="ActivateHotel?id=${o.id}&check=${o.status}&page=LoadHotels"
                       class="badge badge-inactive" title="Change status">Inactive</a>
                </div>
            </c:if>
            <div class="table__cell align-center">
                <div class="priority
                     <c:if test="${o.priority == 1}">priority-1</c:if>
                     <c:if test="${o.priority == 2}">priority-2</c:if>
                     <c:if test="${o.priority == 3}">priority-3</c:if>
                     <c:if test="${o.priority == 4}">priority-4</c:if>
                     <c:if test="${o.priority == 5}">priority-5</c:if>
                ">
                    <div class="set-priority">
                        <a href="EditPriority?id=${o.id}&priority=1" class="option"><p class="op-1">Priority: 1</p></a>
                        <a href="EditPriority?id=${o.id}&priority=2" class="option"><p class="op-2">Priority: 2</p></a>
                        <a href="EditPriority?id=${o.id}&priority=3" class="option"><p class="op-3">Priority: 3</p> </a>
                        <a href="EditPriority?id=${o.id}&priority=4" class="option"><p class="op-4">Priority: 4</p></a>
                        <a href="EditPriority?id=${o.id}&priority=5" class="option"><p class="op-5">Priority: 5</p></a>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</div>


<div class="noti close-btn open">
    <div class="noti-container">
        <div class="noti-heading">
            <h3 class="heading">Choose Accout for staff</h3>
            <div class="close-btn"><i class="fas fa-times"></i></div>
        </div>
        <div class="noti-body">
            <p class="message mt-12">Your booking has been successful!</p>
            <span class="message mt-12"> Your account has been created: </span>
            <p><span class="label mt-12">Username:</span>${sessionScope.Account.username}</p>
            <p><span class="label">Password:</span>${requestScope.pass}</p>
        </div>
        <div class="edit-btn">
            <a href="edituser.jsp" class="btn">Edit Profile</a>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
        integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
    function searchHotel(acc) {
        var txtSearch = acc.value;
        $.ajax({
            url: '/Trividi_Project/SearchHotel',
            type: 'post',
            data: {
                hotelname: txtSearch
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
</body>

</html>