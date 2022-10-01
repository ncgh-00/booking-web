<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/2/2022
  Time: 1:07 AM
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
            <div class="col col-8">edit</div>
            <div class="col col-9">del</div>

        </li>

        <li class="table-row">
            <div class="col col-1" data-label="Location">${hotel.name}</div>
            <div class="col col-2" data-label="Category">${hotel.category}</div>
            <div class="col col-3" data-label="Phone"> ${hotel.phone}</div>
            <div class="col col-4" data-label="Address">${hotel.address}</div>
            <div class="col col-5" data-label="Number Of Star">${hotel.star}</div>
            <div class="col col-6" data-label="City">${hotel.city}</div>
            <c:if test="${hotel.status == true}">
                <div class="col col-7" data-label="Status"><a class="badge badge-confirm">active</a></div>

            </c:if>

            <c:if test="${hotel.status == false}">
                <div class="col col-7" data-label="Status"><a class="badge badge-updating">inactive</a></div>

            </c:if>

            <div class="col col-9" data-label="">
                <a href="#t" class="delete" data-toggle="modal">
                    <i class="material-icons" data-toggle="tooltip" title="Delete">
                        &#xE872;
                    </i>
                </a>
            </div>

        </li>

    </ul>

    <h2>Manage Booking</h2>
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-1">Name of room</div>
            <div class="col col-2">Cost</div>
            <div class="col col-3">Discount</div>
            <div class="col col-4">Status</div>
            <div class="col col-5">edit</div>
            <div class="col col-6">del</div>

        </li>
        <c:forEach items="${listA}" var="o">
            <li class="table-row">
                <div class="col col-1" data-label="Name of room">${o.name}</div>
                <div class="col col-2" data-label="Cost">${o.cost}</div>
                <div class="col col-3" data-label="Discount"> ${o.discount}</div>
                <c:if test="${o.status == true}">
                    <div class="col col-4" data-label="Status"><a class="badge badge-confirm">active</a></div>

                </c:if>

                <c:if test="${o.status == false}">
                    <div class="col col-4" data-label="Status"><a class="badge badge-updating">inactive</a></div>

                </c:if>

                <div class="col col-8" data-label="">
                    <a href="#t" class="delete" data-toggle="modal">
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
