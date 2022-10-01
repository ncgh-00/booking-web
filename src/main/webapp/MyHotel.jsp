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
    <title>My Hotel</title>

    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <!-- custom css file link  -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/myaccount.css">

</head>
<body>
<div class="container">
    <h2>Manage Hotel</h2>
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-1">Location</div>

        </li>

        <c:forEach items="${listB}" var="o">
            <li class="table-row">
                <div class="col col-1" data-label="Location">${o.hotelName}</div>




            </li>
        </c:forEach>

        </li>

    </ul>
</div>
</body>
</html>
