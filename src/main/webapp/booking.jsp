<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking page</title>

    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>

    <!-- font awesome cdn link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <link href="./css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<!-- header section starts -->
<jsp:include page="header.jsp"></jsp:include>
<!-- header section ends -->

<!-- Hotel detail section starts -->
<section class="hot-hotel mt-body" id="hot-hotel">
    <h1 class="heading">
        <span>H</span>
        <span>o</span>
        <span>t</span>
        <span>e</span>
        <span>l</span>
        <span class="space"></span>
        <span>D</span>
        <span>e</span>
        <span>t</span>
        <span>a</span>
        <span>i</span>
        <span>l</span>
        <span>s</span>
    </h1>

    <div class="row">
        <div class="img">
            <img src="${hotel.image}" alt="">
        </div>

        <div class="hot-hotel-content">
            <div class="hotel-info">
                <h2>${hotel.name}</h2>

                <div class="stars">
                    <c:forEach begin="1" end="${hotel.star}">
                        <i class="fas fa-star"></i>
                    </c:forEach>
                </div>

                <h3>${hotel.des}</h3>
                <h3>
                    <i class="fa-solid fa-phone"></i>
                    Phone: <a href="tel:+${hotel.phone}"></a> ${hotel.phone}
                </h3>
                <h3>
                    <i class="fa-sharp fa-solid fa-location-dot"></i>
                    Address: ${hotel.address}
                </h3>

                <a href="#" class="btn"> Book now</a>
            </div>
        </div>
    </div>
</section>


<!-- Hotel detail section ends -->

<!-- Room section start -->
<section class="review" id="review">
    <h1 class="heading">
        <span>O</span>
        <span>u</span>
        <span>r</span>
        <span class="space"></span>
        <span>R</span>
        <span>o</span>
        <span>o</span>
        <span>m</span>
        <span>s</span>
    </h1>

    <div class="swiper mySwiper review-slider">
        <div class="swiper-wrapper wrapper">
            <c:forEach items="${listR}" var="o">
                <div class="swiper-slide">
                    <div class="box">
                        <img src="${o.images}" alt="room image">
                        <h3>${o.name}</h3>
                        <p>${o.des}</p>
                        <div class="stars">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="far fa-star"></i>
                        </div>
                        <p>${Math.ceil(o.cost*(1-o.discount/100)/24000)} $ <span class="dis">${Math.ceil(o.cost/24000)} $</span><span> <br> Per Night </span>
                        </p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    </div>
</section>

<!-- Room section ends -->

<!-- book section starts -->
<section class="book" id="book">
    <h1 class="heading">
        <span>b</span>
        <span>o</span>
        <span>o</span>
        <span>k</span>
        <span class="space"></span>
        <span>n</span>
        <span>o</span>
        <span>w</span>
    </h1>

    <div class="row">
        <div class="img">
            <img src="./images/book-img.svg" alt="">
        </div>

        <form action="">
            <div class="inputBox">
                <h3>where to</h3>
                <input type="text" placeholder="place name">
            </div>
            <div class="inputBox">
                <h3>how many</h3>
                <input type="number" placeholder="number of guests">
            </div>
            <div class="inputBox">
                <h3>arrivals</h3>
                <input type="date">
            </div>
            <div class="inputBox">
                <h3>leaving</h3>
                <input type="date">
            </div>
            <input type="submit" class="btn" value="book now">
        </form>
    </div>
</section>
<!-- book section ends -->

<!--footer section starts-->
<jsp:include page="footer.jsp"></jsp:include>
<!--footer section ends-->

<script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
<!-- custome js file link -->
<script src="./js/slider.js" type="text/javascript"></script>
</body>

</html>
