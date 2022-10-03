<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/2/2022
  Time: 1:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Hotel</title>

    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <!-- custom css file link  -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/myaccount.css">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <h2>Manage Hotel</h2>
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-1">Hotel Name</div>
            <div class="col col-2">Category</div>
            <div class="col col-3">Phone</div>
            <div class="col col-4">Address</div>
            <div class="col col-5">Number Of Star</div>
            <div class="col col-6">City</div>
            <div class="col col-7">Status</div>
            <div class="col col-8">Action</div>

        </li>

        <li class="table-row">
            <div class="col col-1" data-label="Location">${hotel.name}</div>
            <div class="col col-2" data-label="Category">${hotel.category}</div>
            <div class="col col-3" data-label="Phone"> ${hotel.phone}</div>
            <div class="col col-4" data-label="Address">${hotel.address}</div>
            <div class="col col-5" data-label="Number Of Star">${hotel.star}</div>
            <div class="col col-6" data-label="City">${hotel.city}</div>
            <c:if test="${hotel.status == true}">
                <div class="col col-7" data-label="Status"><a
                        href="ActivateHotel?id=${hotel.id}&check=${hotel.status}&page=LoadMyHotel"
                        class="badge badge-confirm">active</a></div>

            </c:if>
            <c:if test="${hotel.status == false}">
                <div class="col col-7" data-label="Status"><a
                        href="ActivateHotel?id=${hotel.id}&check=${hotel.status}&page=LoadMyHotel"
                        class="badge badge-updating">inactive</a></div>

            </c:if>
            <a href="LoadEditHotel"><i class="fas fa-edit col col-8"></i></a>


        </li>

    </ul>

    <h2>Manage Room Details</h2>
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-1">Name of room</div>
            <div class="col col-2">Cost</div>
            <div class="col col-3">Discount</div>
            <div class="col col-4">Status</div>
            <div class="col col-5">Action</div>

        </li>
        <c:forEach items="${listRD}" var="o">
            <li class="table-row">
                <div class="col col-1" data-label="Name of room">${o.name}</div>
                <div class="col col-2" data-label="Cost">${o.cost}</div>
                <div class="col col-3" data-label="Discount"> ${o.discount}</div>

                <c:if test="${o.status == true}">
                    <div class="col col-4" data-label="Status"><a
                            href="ActivateRoom?id=${o.id}&check=${o.status}&page=LoadMyHotel"
                            class="badge badge-confirm">active</a></div>
                </c:if>
                <c:if test="${o.status == false}">
                    <div class="col col-4" data-label="Status"><a
                            href="ActivateRoom?id=${o.id}&check=${o.status}&page=LoadMyHotel"
                            class="badge badge-updating">inactive</a></div>
                </c:if>

                <a href="editroom.jsp"><i class="fas fa-edit col col-5"></i></a>

            </li>
        </c:forEach>
    </ul>
    <h2>Manage Booking</h2>
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-1">User name</div>
            <div class="col col-2">Phone</div>
            <div class="col col-3">Email</div>

            <div class="col col-4">Location</div>
            <div class="col col-5">Room name</div>
            <div class="col col-6">Amount</div>
            <div class="col col-7">Day Start</div>
            <div class="col col-8">Day End</div>
            <div class="col col-9">Total Cost</div>
            <div class="col col-10">Status</div>
        </li>

        <c:forEach items="${listMB}" var="a">
            <li class="table-row">
                <c:if test="${a.confirm == true}">
                    <div class="col col-1" data-label="username">${a.userName}</div>
                    <div class="col col-2" data-label="userphone">${a.userPhone}</div>
                    <div class="col col-3" data-label="useremail">${a.userEmail}</div>
                </c:if>
                <c:if test="${a.confirm == false}">
                    <div class="col col-1" data-label="username"></div>
                    <div class="col col-2" data-label="userphone"></div>
                    <div class="col col-3" data-label="useremail"></div>
                </c:if>
                <div class="col col-4" data-label="hotelname">${a.hotelName}</div>
                <div class="col col-5" data-label="roomname">${a.roomName}</div>
                <div class="col col-6" data-label="amount"> ${a.numOfRoom}</div>
                <div class="col col-7" data-label="daystart">${a.dateStart}</div>
                <div class="col col-8" data-label="dayend">${a.dateEnd}</div>
                <div class="col col-9" data-label="totalcost">${a.totalCost}</div>
                <c:if test="${a.confirm == true}">
                    <div class="col col-10" data-label="Status"><a
                            href="ConfirmBooking?id=${a.idBooking}&check=${a.confirm}&id_staff=${sessionScope.Account.UID}&page=LoadMyHotel"
                            class="badge badge-confirm">active</a></div>
                    <%--                    ConfirmBooking?id=${a.idBooking}&check=${a.confirm}&id_staff=${sessionScope.Account.UID}&page=LoadMyHotel--%>
                </c:if>
                <c:if test="${a.confirm == false}">
                    <div class="col col-10" data-label="Status"><a
                            href="ConfirmBooking?id=${a.idBooking}&check=${a.confirm}&id_staff=${sessionScope.Account.UID}&page=LoadMyHotel"
                            class="badge badge-updating">inactive</a></div>
                    <%--                    ConfirmBooking?id=${a.idBooking}&check=${a.confirm}&id_staff=${sessionScope.Account.UID}&page=LoadMyHotel--%>
                </c:if>
            </li>

        </c:forEach>


    </ul>
</div>
</body>
</html>
