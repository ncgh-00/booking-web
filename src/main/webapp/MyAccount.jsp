<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/30/2022
  Time: 11:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your booking</title>

    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <!-- custom css file link  -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/myaccount.css">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <div class="info-container">
        <div class="title">Order Information
            <h3>Update your info and find out how it's used.</h3>
        </div>
        <div class="user-detail">
            <div class="infor">
                <span class="details">Fullname:  ${o.fullname}</span>
            </div>
            <div class="infor">
                <span class="details">Username:  ${o.username}</span>
            </div>
            <div class="infor">
                <span class="details">Email:  ${o.email}</span>
            </div>
            <div class="infor">
                <span class="details">Phone:  ${o.phone}</span>
            </div>
            <div>
                <a href="edit_user.jsp" class="btn">Edit Profile</a>
            </div>

        </div>
    </div>
</div>

<!-- table -->

<div class="container">
    <h2>Your Booking</h2>
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-1">Location</div>
            <div class="col col-2">Room name</div>
            <div class="col col-3">Amount</div>
            <div class="col col-4">Day Start</div>
            <div class="col col-5">Day End</div>
            <div class="col col-6">Total Cost</div>
            <div class="col col-7">Status</div>
            <div class="col col-8"></div>
        </li>

        <c:forEach items="${listB}" var="o">
            <li class="table-row">
                <div class="col col-1" data-label="Location">${o.hotelName}</div>
                <div class="col col-2" data-label="Room name">${o.roomName}</div>
                <div class="col col-3" data-label="Amount"> ${o.numOfRoom}</div>
                <div class="col col-4" data-label="Day Start">${o.dateStart}</div>
                <div class="col col-5" data-label="Day End">${o.dateEnd}</div>
                <div class="col col-6" data-label="Total Cost">${o.totalCost}</div>
                <c:if test="${o.confirm == true}">
                    <div class="col col-7" data-label="Status"><a class="badge badge-confirm">confirm</a></div>

                </c:if>
                <c:if test="${o.confirm == false}">
                    <div class="col col-7" data-label="Status"><a class="badge badge-updating">updating</a></div>

                </c:if>

                <div class="col col-8" data-label="">
                    <a href="DeleteBooking?id=${o.idBooking}&&page=MyAccount" class="delete" data-toggle="modal">
                        <i class="material-icons" data-toggle="tooltip" title="Delete">
                            &#xE872;
                        </i>
                    </a>
                </div>

            </li>
        </c:forEach>



    </ul>
</div>

</body>
</html>
