
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Hotel</title>
    <link rel="icon" type="image/x-icon" href="./images/logo.svg">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <!-- custom css file link  -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/myaccount.css">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container margin-top margin-bottom">
    <section class="hot-hotel " id="managehotel">
        <h1 class="heading">
            <span>M</span>
            <span>a</span>
            <span>n</span>
            <span>a</span>
            <span>g</span>
            <span>e</span>
            <span class="space"></span>
            <span>H</span>
            <span>o</span>
            <span>t</span>
            <span>e</span>
            <span>l</span>
        </h1>
        <div class="add-room"><a class="btn" href="LoadStatistic?id=${hotel.id}&year=&month=">View Statistic</a></div>
        <div class="row">
            <div class="img">
                <img src="${hotel.image}" alt="">
            </div>

            <div class="hot-hotel-content">
                <div class="hotel-info">
                    <h2 style=" margin: 0;">${hotel.name}</h2>

                    <div class="stars">
                        <c:forEach begin="1" end="${hotel.star}">
                            <i class="fas fa-star"></i>
                        </c:forEach>
                    </div>

                    <h3 class="hotel-desc">${hotel.des}</h3>
                    <h3>
                        <i class="fa-solid fa-phone"></i>
                        Phone: <a href="tel:+${hotel.phone}"><span>${hotel.phone}</span></a>
                    </h3>
                    <h3>
                        <i class="fa-sharp fa-solid fa-location-dot"></i>
                        Address: <span>${hotel.address}</span>
                    </h3>
                    <c:if test="${hotel.status == true}">
                        <div class="align-center" data-label="Status"><a title="Change status" href="ActivateHotel?id=${hotel.id}&check=${hotel.status}&page=LoadMyHotel&pageposition=#managehotel" class="badge-hotel badge-confirm">active</a></div>
                    </c:if>
                    <c:if test="${hotel.status == false}">
                        <div class=" align-center" data-label="Status"><a title="Change status" href="ActivateHotel?id=${hotel.id}&check=${hotel.status}&page=LoadMyHotel&pageposition=#managehotel" class="badge-hotel badge-updating">inactive</a></div>
                    </c:if>
                    <a href="EditHotel?idh=${hotel.id}" class="btn">Edit Hotel</a>
                    <a href="?LoadMaplng=${requestScope.location.lng}&lat=${requestScope.location.lat}" class="btn mg-l"> See In Map</a>
                </div>
            </div>
        </div>
    </section>


    <h1 class="heading" id="manageroom">
        <span>M</span>
        <span>a</span>
        <span>n</span>
        <span>a</span>
        <span>g</span>
        <span>e</span>
        <span class="space"></span>
        <span>R</span>
        <span>O</span>
        <span>O</span>
        <span>M</span>
    </h1>
    <div class="add-room"><a class="btn" href="addroom.jsp?idh=${hotel.id}">Add room</a></div>
    <ul class="responsive-table ">
        <li class="table-header">
            <div class="col col-l">Name of room</div>
            <div class="col col-xl">Description</div>
            <div class="col col-m">Image</div>
            <div class="col col-s">Cost</div>
            <div class="col col-s">Discount</div>
            <div class="col col-xs">Status</div>
            <div class="col col-xs">Action</div>

        </li>
        <c:forEach items="${listRD}" var="o">
            <li class="table-row">
                <div class="col col-l align-center" data-label="Name of room">${o.name}</div>
                <div class="col col-xl" data-label="Description">${o.des}</div>
                <div class="col col-m align-center" data-label="Image">${o.images}</div>
                <div class="col col-s align-center" data-label="Cost">${o.cost}</div>
                <div class="col col-s align-center" data-label="Discount"> ${o.discount}</div>

                <c:if test="${o.status == true}">
                    <div class="col col-xs align-center" data-label="Status"><a title="Change status"
                            href="ActivateRoom?id=${o.id}&check=${o.status}&page=LoadMyHotel&pageposition=#manageroom"
                            class="badge badge-confirm">active</a></div>
                </c:if>
                <c:if test="${o.status == false}">
                    <div class="col col-xs align-center" data-label="Status"><a title="Change status"
                            href="ActivateRoom?id=${o.id}&check=${o.status}&page=LoadMyHotel&pageposition=#manageroom"
                            class="badge badge-updating">inactive</a></div>
                </c:if>
                <div class="col col-xs align-center">
                <a class="edit" href="EditRoom?idr=${o.id}"><i class="icon fa-solid fa-pen-to-square"></i></a>
                </div>
            </li>
        </c:forEach>
    </ul>
    <h1 class="heading" id="managebooking">
        <span>M</span>
        <span>a</span>
        <span>n</span>
        <span>a</span>
        <span>g</span>
        <span>e</span>
        <span class="space"></span>
        <span>B</span>
        <span>o</span>
        <span>o</span>
        <span>k</span>
        <span>i</span>
        <span>n</span>
        <span>g</span>
    </h1>
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-s">User name</div>
            <div class="col col-s">Phone</div>
            <div class="col col-m">Email</div>

            <div class="col col-xl">Location</div>
            <div class="col col-l">Room name</div>
            <div class="col col-xs">Amount</div>
            <div class="col col-m">Day Start</div>
            <div class="col col-m">Day End</div>
            <div class="col col-s">Total Cost</div>
            <div class="col col-xs">Status</div>
        </li>

        <c:forEach items="${listMB}" var="a">
            <li class="table-row">
                <c:if test="${a.confirm == true}">
                    <div class="col col-s align-center" data-label="username">${a.fullName}</div>
                    <div class="col col-s align-center" data-label="userphone">${a.userPhone}</div>
                    <div class="col col-m align-center" data-label="useremail">${a.userEmail}</div>
                </c:if>
                <c:if test="${a.confirm == false}">
                    <div class="col col-s align-center" data-label="username"><i class="icon fa-sharp fa-solid fa-eye-slash"></i></div>
                    <div class="col col-s align-center" data-label="userphone"><i class="icon fa-sharp fa-solid fa-eye-slash"></i></div>
                    <div class="col col-m align-center" data-label="useremail"><i class="icon fa-sharp fa-solid fa-eye-slash"></i></div>
                </c:if>
                <div class="col col-xl" data-label="hotelname">${a.hotelName}</div>
                <div class="col col-l align-center" data-label="roomname">${a.roomName}</div>
                <div class="col col-xs align-center" data-label="amount"> ${a.numOfRoom}</div>
                <div class="col col-m align-center" data-label="daystart">${a.dateStart}</div>
                <div class="col col-m align-center" data-label="dayend">${a.dateEnd}</div>
                <div class="col col-s align-center" data-label="totalcost">${a.totalCost}</div>
                <c:if test="${a.confirm == true}">
                    <div class="col col-xs align-center" data-label="Status"><a title="Change status"
                            href="ConfirmBooking?id=${a.idBooking}&check=${a.confirm}&id_staff=${sessionScope.Account.UID}&page=LoadMyHotel&pageposition=#managebooking"
                            class="badge badge-confirm">Confirm</a></div>
                </c:if>
                <c:if test="${a.confirm == false}">
                    <div class="col col-xs align-center" data-label="Status"><a title="Change status"
                            href="ConfirmBooking?id=${a.idBooking}&check=${a.confirm}&id_staff=${sessionScope.Account.UID}&page=LoadMyHotel&pageposition=#managebooking"
                            class="badge badge-updating">Updating</a></div>
                </c:if>
            </li>

        </c:forEach>
    </ul>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<script src="./js/header.js"></script>
</body>
</html>
