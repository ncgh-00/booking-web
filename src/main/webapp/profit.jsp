<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/dashboard.css">
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="menu">
    <ul class="menu__bar">
        <a class="menu__item" href="">
            <li>Hotel Management</li>
        </a>
        <a class="menu__item" href="">
            <li>Account Management</li>
        </a>
        <a class="menu__item selected" href="">
            <li>statistic</li>
        </a>
    </ul>
</div>

<div class="card-container">
    <div class="card card-orange">
        <div class="card__heading">
            <div class="card__content">
                <h3 class="card__number">$3020</h3>
                <p class="card__details">all profits</p>
            </div>
            <div class="card__icon"><i class="fa-solid fa-money-bill-trend-up"></i></div>
        </div>
        <div class="line"></div>
        <div class="card__footer">
            <i class="fa-regular fa-clock"></i>
            <p class="card_time">update: 2:15 am</p>
        </div>
    </div>

    <div class="card card-green">
        <div class="card__heading">
            <div class="card__content">
                <h3 class="card__number">$3020</h3>
                <p class="card__details">all bookings</p>
            </div>
            <div class="card__icon"><i class="fa-solid fa-rectangle-list"></i></div>
        </div>
        <div class="line"></div>
        <div class="card__footer">
            <i class="fa-regular fa-clock"></i>
            <p class="card_time">update: 2:15 am</p>
        </div>
    </div>

    <div class="card card-red">
        <div class="card__heading">
            <div class="card__content">
                <h3 class="card__number">$3020</h3>
                <p class="card__details">Day's profits</p>
            </div>
            <div class="card__icon"><i class="fa-solid fa-money-bill-trend-up"></i></div>
        </div>
        <div class="line"></div>
        <div class="card__footer">
            <i class="fa-regular fa-clock"></i>
            <p class="card_time"> update: 2:15 am</p>
        </div>
    </div>

    <div class="card card-blue">
        <div class="card__heading">
            <div class="card__content">
                <h3 class="card__number">$3020</h3>
                <p class="card__details">Day's bookings</p>
            </div>
            <div class="card__icon"><i class="fa-solid fa-rectangle-list"></i></div>
        </div>
        <div class="line"></div>
        <div class="card__footer">
            <i class="fa-regular fa-clock"></i>
            <p class="card_time"> update: 2:15 am</p>
        </div>
    </div>
</div>

<form action="" class="form-search">
    <input type="number" class="search-bar" placeholder="Month" min="1" max="12">
    <input type="number" class="search-bar" placeholder="Year" min="2022">

    <input type="submit" value="View" class="btn">
</form>

<div class="chart-container">

</div>


<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
