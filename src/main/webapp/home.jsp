<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="icon" type="image/x-icon" href="./images/logo.svg">
    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>

    <!-- font awesome cdn link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <!-- custome css file link -->
    <link rel="stylesheet" href="./css/style.css">
</head>

<body>

<!-- header section starts -->
<jsp:include page="header.jsp"></jsp:include>
<!--  section ends -->

<!-- home section starts -->
<section class="home ${search==1?"hidden":""}" id="home">
    <div class="content">
        <h3>welcome to A global icon of luxury</h3>
        <p>dicover new places with us, luxury awaits</p>
        <a href="#" class="btn">discover more</a>
    </div>

    <div class="controls">
        <span class="vid-btn active" data-src="images/vid-1.mp4"></span>
        <span class="vid-btn" data-src="images/vid-2.mp4"></span>
        <span class="vid-btn" data-src="images/vid-3.mp4"></span>
        <span class="vid-btn" data-src="images/vid-4.mp4"></span>
        <span class="vid-btn" data-src="images/vid-5.mp4"></span>
    </div>

    <div class="video-container">
        <video src="images/vid-1.mp4" id="video-slider" loop autoplay muted></video>
    </div>

</section>


<!-- home section ends -->

<!-- Hot hotel section starts -->

<section class="hot-hotel ${search==1?"hidden":""}" id="hot-hotel">
    <h1 class="heading">
        <span>H</span>
        <span>o</span>
        <span>t</span>
        <span class="space"></span>
        <span>H</span>
        <span>o</span>
        <span>t</span>
        <span>e</span>
        <span>l</span>
    </h1>

    <div class="row">
        <div class="img">
            <img src="${hotel_details.image}" alt="">
        </div>

        <div class="hot-hotel-content">
            <div class="hotel-info">
                <h2>${hotel_details.name}</h2>

                <div class="stars">
                    <c:forEach begin="1" end="${hotel_details.star}">
                        <i class="fas fa-star"></i>
                    </c:forEach>
                </div>

                <h3 class="hotel-desc">${hotel_details.des}</h3>
                <h3>
                    <i class="fa-solid fa-phone"></i>
                    Phone: <a href="tel:+${hotel_details.phone}"><span>${hotel_details.phone}</span></a>
                </h3>
                <h3>
                    <i class="fa-sharp fa-solid fa-location-dot"></i>
                    Address: <span>${hotel_details.address}</span>
                </h3>

                <a href="LoadBooking?id=${hotel_details.id}" class="btn"> Book now</a>
            </div>
        </div>
    </div>
</section>
<!-- Hot hotel section ends -->


<!-- Hotel section starts -->

<section class="hotel ${search==1?"mt-body":""}" id="hotel">
    <c:if test="${search!=1}">
    <h1 class="heading">
        <span>H</span>
        <span>o</span>
        <span>t</span>
        <span>e</span>
        <span>l</span>
    </h1>
    </c:if>

    <c:if test="${search==1}">
        <h1 class="heading">
            <span>S</span>
            <span>e</span>
            <span>a</span>
            <span>r</span>
            <span>c</span>
            <span>h</span>
            <span class="space"></span>
            <span>R</span>
            <span>e</span>
            <span>s</span>
            <span>u</span>
            <span>l</span>
            <span>t</span>
            <span>s</span>
        </h1>
    </c:if>
    <div class="box-container">
        <c:forEach items="${listH}" var="o">
            <div class="box">
                <img src="${o.image}" alt="">
                <div class="content">
                    <h3><i class="fas fa-map-marker-alt"></i> ${o.city} </h3>
                    <p>${o.name}</p>
                    <div class="stars">
                        <c:forEach begin="1" end="${o.star}">
                            <i class="fas fa-star"></i>
                        </c:forEach>
                    </div>
                    <div class="price"> ${Math.ceil(o.cost*(1-o.discount/100)/24000)} $ <span>${Math.ceil(o.cost/24000)} $</span>
                    </div>
                        <%--                    <c:if test="${sessionScope.Account.username == null}">--%>
                        <%--                        <a href="login.jsp" class="btn">book now</a>--%>
                        <%--                    </c:if>--%>
                        <%--                    <c:if test="${sessionScope.Account.username != null}">--%>
                    <a href="LoadBooking?id=${o.id}" class="btn">book now</a>
                        <%--                    </c:if>--%>
                </div>
            </div>
        </c:forEach>


    </div>

</section>


<!-- packages section ends -->

<!-- city section starts -->

<section class="city ${search==1?"hidden":""}" id="city">
    <h1 class="heading">
        <span>c</span>
        <span>i</span>
        <span>t</span>
        <span>y</span>
    </h1>

    <div class="box-container">
        <c:forEach items="${listC}" var="o">
            <div class="box">
                <img src="${o.link_images}" alt="">
                <div class="content">
                    <h3>${o.name}</h3>

                    <a href="Search?search-by-city=${o.name}" class="btn">see more</a>
                </div>

            </div>
        </c:forEach>

    </div>

</section>

<!-- city section ends -->

<!-- services section starts -->

<section class="services ${search==1?"hidden":""}" id="services">
    <h1 class="heading">
        <span>s</span>
        <span>e</span>
        <span>r</span>
        <span>v</span>
        <span>i</span>
        <span>c</span>
        <span>e</span>
        <span>s</span>
    </h1>

    <div class="box-container">
        <div class="box">
            <i class="fas fa-hotel"></i>
            <h3>affordable hotels</h3>
            <p>Coming to Trividi Joint Stock Company, customers will always find hotels with affordable prices but receive the best service.
                Additionally, we frequently give discounts on our website so that clients always get the best deals.</p>
        </div>
        <div class="box">
            <i class="fas fa-utensils"></i>
            <i class="fa-light fa-cart-shopping-fast"></i>
            <h3>fast to booking</h3>
            <p>The Trividi website always strives to make using it simple so that users can simply search hotel information and book hotels.</p>
        </div>
        <div class="box">
            <i class="fas fa-bullhorn"></i>
            <h3>safty guide</h3>
            <p>Users' security is always of the utmost importance, so they can be entirely confident while submitting their information on the Trividi website.</p>
        </div>
        <div class="box">
            <i class="fas fa-globe-asia"></i>
            <h3>around the country</h3>
            <p>Our service is spread across the country with many hotels everywhere, so coming to Trividi booking website, customers will always find the right hotel for their needs.</p>
        </div>
        <div class="box">
            <i class="fa-solid fa-map-location-dot"></i>
            <h3>easy to find</h3>
            <p>The map tool on the Trividi booking website makes it simple for customers to look up hotels and entertainment venues in the area.</p>
        </div>
        <div class="box">
            <i class="fas fa-hiking"></i>
            <h3>adventures</h3>
            <p>Find out more about the hotel you wish to stay at with the assistance of actual images and reviews from prior guests to make your decision easier.</p>
        </div>
    </div>
</section>

<!-- services section ends -->

<!-- brand section -->

<section class="brand-container">
    <div class="swiper mySwiper brand-slider">
        <div class="swiper-wrapper wrapper">
            <div class="swiper-slide"><img src="images/1.jpg" alt=""></div>
            <div class="swiper-slide"><img src="images/2.jpg" alt=""></div>
            <div class="swiper-slide"><img src="images/3.jpg" alt=""></div>
            <div class="swiper-slide"><img src="images/4.jpg" alt=""></div>
            <div class="swiper-slide"><img src="images/5.jpg" alt=""></div>
            <div class="swiper-slide"><img src="images/6.jpg" alt=""></div>
        </div>
    </div>
</section>
<!-- footer section -->
<jsp:include page="footer.jsp"></jsp:include>

<script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
<!-- custome js file link -->
<script src="./js/script.js"></script>
<script>
    function checkRequired(input) {
        var text = input.value;
        const great = document.getElementById("option-1")
        const attr = document.createAttribute("required");
        if(text != ""){
            great.setAttributeNode(attr);
        }
    }
</script>
</body>

</html>
