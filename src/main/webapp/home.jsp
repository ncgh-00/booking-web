<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>complete responsive hotel agency website design </title>

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
<section class="home" id="home">
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

<section class="hot-hotel" id="hot-hotel">
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
            <img src="images/book-img.svg" alt="">
        </div>

        <div class="hot-hotel-content">
            <div class="hotel-info">
                <h2>where to</h2>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="far fa-star"></i>
                </div>
                <h3>how many</h3>
                <h3>
                    <i class="fa-solid fa-phone"></i>
                    Phone: <a href="tel:+0000"></a> 0000
                </h3>
                <h3>
                    <i class="fa-sharp fa-solid fa-location-dot"></i>
                    Address: 0000
                </h3>

                <a href="#" class="btn"> Book now</a>
            </div>
        </div>
</section>
<!-- Hot hotel section ends -->


<!-- Hotel section starts -->

<section class="hotel" id="hotel">
    <h1 class="heading">
        <span>H</span>
        <span>o</span>
        <span>t</span>
        <span>e</span>
        <span>l</span>
    </h1>

    <div class="box-container">
        <div class="box">
            <img src="images/p-1.jpg" alt="">
            <div class="content">
                <h3><i class="fas fa-map-marker-alt"></i> mumbai </h3>
                <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.</p>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="far fa-star"></i>
                </div>
                <div class="price"> $90.00 <span>$120.00</span></div>
                <a href="#" class="btn">book now</a>
            </div>
        </div>

        <div class="box">
            <img src="images/p-2.jpg" alt="">
            <div class="content">
                <h3><i class="fas fa-map-marker-alt"></i> sydney </h3>
                <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.</p>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="far fa-star"></i>
                </div>
                <div class="price"> $90.00 <span>$120.00</span></div>
                <a href="#" class="btn">book now</a>
            </div>
        </div>

        <div class="box">
            <img src="images/p-3.jpg" alt="">
            <div class="content">
                <h3><i class="fas fa-map-marker-alt"></i> hawaii </h3>
                <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.</p>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="far fa-star"></i>
                </div>
                <div class="price"> $90.00 <span>$120.00</span></div>
                <a href="#" class="btn">book now</a>
            </div>
        </div>

        <div class="box">
            <img src="images/p-4.jpg" alt="">
            <div class="content">
                <h3><i class="fas fa-map-marker-alt"></i> paris </h3>
                <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.</p>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="far fa-star"></i>
                </div>
                <div class="price"> $90.00 <span>$120.00</span></div>
                <a href="#" class="btn">book now</a>
            </div>
        </div>

        <div class="box">
            <img src="images/p-5.jpg" alt="">
            <div class="content">
                <h3><i class="fas fa-map-marker-alt"></i> tokyo </h3>
                <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.</p>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="far fa-star"></i>
                </div>
                <div class="price"> $90.00 <span>$120.00</span></div>
                <a href="#" class="btn">book now</a>
            </div>
        </div>

        <div class="box">
            <img src="images/p-6.jpg" alt="">
            <div class="content">
                <h3><i class="fas fa-map-marker-alt"></i> eypt </h3>
                <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.</p>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="far fa-star"></i>
                </div>
                <div class="price"> $90.00 <span>$120.00</span></div>
                <a href="#" class="btn">book now</a>
            </div>
        </div>
    </div>
</section>


<!-- packages section ends -->

<!-- city section starts -->

<section class="city" id="city">
    <h1 class="heading">
        <span>c</span>
        <span>i</span>
        <span>t</span>
        <span>y</span>
    </h1>

    <div class="box-container">
        <div class="box">
            <img src="images/g-1.jpg" alt="">
            <div class="content">
                <h3>amazing places</h3>
                <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.</p>
                <a href="#" class="btn">see more</a>
            </div>
        </div>
        <div class="box">
            <img src="images/g-2.jpg" alt="">
            <div class="content">
                <h3>amazing places</h3>
                <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.</p>
                <a href="#" class="btn">see more</a>
            </div>
        </div>
        <div class="box">
            <img src="images/g-3.jpg" alt="">
            <div class="content">
                <h3>amazing places</h3>
                <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.</p>
                <a href="#" class="btn">see more</a>
            </div>
        </div>
        <div class="box">
            <img src="images/g-4.jpg" alt="">
            <div class="content">
                <h3>amazing places</h3>
                <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.</p>
                <a href="#" class="btn">see more</a>
            </div>
        </div>
        <div class="box">
            <img src="images/g-5.jpg" alt="">
            <div class="content">
                <h3>amazing places</h3>
                <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.</p>
                <a href="#" class="btn">see more</a>
            </div>
        </div>
        <div class="box">
            <img src="images/g-6.jpg" alt="">
            <div class="content">
                <h3>amazing places</h3>
                <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.</p>
                <a href="#" class="btn">see more</a>
            </div>
        </div>
        <div class="box">
            <img src="images/g-7.jpg" alt="">
            <div class="content">
                <h3>amazing places</h3>
                <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.</p>
                <a href="#" class="btn">see more</a>
            </div>
        </div>
        <div class="box">
            <img src="images/g-8.jpg" alt="">
            <div class="content">
                <h3>amazing places</h3>
                <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.</p>
                <a href="#" class="btn">see more</a>
            </div>
        </div>
        <div class="box">
            <img src="images/g-9.jpg" alt="">
            <div class="content">
                <h3>amazing places</h3>
                <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.</p>
                <a href="#" class="btn">see more</a>
            </div>
        </div>
    </div>
</section>

<!-- city section ends -->

<!-- services section starts -->

<section class="services" id="services">
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
            <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.
                Lorem Ipsum is simply dummy text of the farhan and typesetting industry
                Lorem Ipsum is simply dummy text of the farhan and typesetting industry</p>
        </div>
        <div class="box">
            <i class="fas fa-utensils"></i>
            <h3>food and drinks</h3>
            <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.
                Lorem Ipsum is simply dummy text of the farhan and typesetting industry
                Lorem Ipsum is simply dummy text of the farhan and typesetting industry</p>
        </div>
        <div class="box">
            <i class="fas fa-bullhorn"></i>
            <h3>safty guide</h3>
            <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.
                Lorem Ipsum is simply dummy text of the farhan and typesetting industry
                Lorem Ipsum is simply dummy text of the farhan and typesetting industry</p>
        </div>
        <div class="box">
            <i class="fas fa-globe-asia"></i>
            <h3>around the world</h3>
            <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.
                Lorem Ipsum is simply dummy text of the farhan and typesetting industry
                Lorem Ipsum is simply dummy text of the farhan and typesetting industry</p>
        </div>
        <div class="box">
            <i class="fas fa-plane"></i>
            <h3>fastest travel</h3>
            <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.
                Lorem Ipsum is simply dummy text of the farhan and typesetting industry
                Lorem Ipsum is simply dummy text of the farhan and typesetting industry</p>
        </div>
        <div class="box">
            <i class="fas fa-hiking"></i>
            <h3>adventures</h3>
            <p>Lorem Ipsum is simply dummy text of the farhan and typesetting industry.
                Lorem Ipsum is simply dummy text of the farhan and typesetting industry
                Lorem Ipsum is simply dummy text of the farhan and typesetting industry</p>
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
</body>

</html>
