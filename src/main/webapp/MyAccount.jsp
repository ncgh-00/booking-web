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
    <link rel="stylesheet" href="css/myaccount.css">
</head>
<body>
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
                <div class="col col-2" data-label="Room name">${o.roomlName}</div>
                <div class="col col-3" data-label="Amount"> ${o.numberOfRoom}</div>
                <div class="col col-4" data-label="Day Start">${o.dateStart}</div>
                <div class="col col-5" data-label="Day End">${o.dateEnd}</div>
                <div class="col col-6" data-label="Total Cost">${o.tolalCost}</div>
                <c:if test="${o.confirm == true}">
                    <div class="col col-7" data-label="Status"><a class="badge badge-confirm">confirm</a></div>
                </c:if>
                <c:if test="${o.confirm == false}">
                    <div class="col col-7" data-label="Status"><a class="badge badge-updating">updating</a></div>
                    <div class="col col-8" data-label=""><a href="DeleteBooking?id=${o.id}&page=HomeBooking"
                                                            class="delete" data-toggle="modal">
                        <i class="material-icons" data-toggle="tooltip" title="Delete">
                            &#xE872;
                        </i>
                    </a>
                    </div>
                </c:if>

            </li>
        </c:forEach>


    </ul>
</div>
</body>
</html>
