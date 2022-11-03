<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your booking</title>
    <link rel="icon" type="image/x-icon" href="./images/logo.svg">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
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
                <span class="details">Fullname:  <p>${sessionScope.Account.fullname}</p></span>
            </div>
            <div class="infor">
                <span class="details">Username:  <p>${sessionScope.Account.username}</p></span>
            </div>
            <div class="infor">
                <span class="details">Email:     <p>${sessionScope.Account.email == null?"You should add your email!":sessionScope.Account.email} </p>
                </span>
            </div>
            <div class="infor">
                <span class="details">Phone:     <p>${sessionScope.Account.phone==null?"You should add your phone!":sessionScope.Account.phone}</p></span>
            </div>
            <div>
                <a href="edituser.jsp" class="btn">Edit Profile</a>
            </div>

        </div>
    </div>
</div>

<!-- table -->

<div id="yourbooking" class="container margin-bottom">
    <h1 class="heading">
        <span>M</span>
        <span>y</span>
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
            <div class="col col-l">Location</div>
            <div class="col col-l">Room name</div>
            <div class="col col-xs">Amount</div>
            <div class="col col-m">Day Start</div>
            <div class="col col-m">Day End</div>
            <div class="col col-s">Total Cost</div>
            <div class="col col-xs">Status</div>
            <div class="col col-xs">Action</div>
        </li>

        <c:forEach items="${listB}" var="o">
            <li class="table-row">
                <div class="col col-l" data-label="Location">${o.hotelName}</div>
                <div class="col col-l align-center" data-label="Room name">${o.roomName}</div>
                <div class="col col-xs align-center" data-label="Amount"> ${o.numOfRoom}</div>
                <div class="col col-m align-center" data-label="Day Start">${o.dateStart}</div>
                <div class="col col-m align-center" data-label="Day End">${o.dateEnd}</div>
                <div class="col col-s align-center" data-label="Total Cost">${o.totalCost}</div>
                <c:if test="${o.confirm == true}">
                    <div class="col col-xs align-center" data-label="Status"><a class="badge badge-confirm">confirm</a></div>

                </c:if>
                <c:if test="${o.confirm == false}">
                    <div class="col col-xs align-center" data-label="Status"><a class="badge badge-updating">updating</a></div>

                </c:if>

                <div class="col col-xs align-center" data-label="">
                    <c:if test="${o.confirm == false}">
                        <a href="DeleteBooking?id=${o.idBooking}&&page=LoadMyAccount" class="delete" data-toggle="modal">
                            <i class="icon material-icons" data-toggle="tooltip" title="Delete">
                                &#xE872;
                            </i>
                        </a>
                    </c:if>
                </div>

            </li>
        </c:forEach>


    </ul>
</div>

<div class="noti close-btn ${show == 1?"open":""} ">
    <div class="noti-container">
        <div class="noti-heading">
            <h3 class="heading">Welcome to Trividi website booking</h3>
            <div class="close-btn"><i class="fas fa-times"></i></div>
        </div>
        <div class="noti-body">
            <p class="message mt-12">Your booking has been successful!</p>
            <span class="message mt-12"> Your account has been created: </span>
            <p><span class="label mt-12">Username:</span>${sessionScope.Account.username}</p>
            <p><span class="label">Password: </span>${requestScope.pass}</p>
        </div>
        <div class="edit-btn">
            <a href="edituser.jsp" class="btn">Edit Profile</a>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<script src="./js/noti.js"></script>
<script src="./js/header.js"></script>
</body>
</html>
