<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking page</title>
    <link rel="icon" type="image/x-icon" href="./images/logo.svg">
    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>

    <!-- font awesome cdn link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <link href="./css/style.css" rel="stylesheet" type="text/css"/>

</head>

<body>
<!-- header section starts -->
<jsp:include page="header.jsp"></jsp:include>
<!-- header section ends -->

<!-- book section starts -->
<section class="book mt-body" id="book">
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
            <img src="./images/travel-img.svg" alt="">
        </div>

        <form action="BookRoom?id=${hotel_details.id}" method="post">
            <c:if test="${sessionScope.Account == null || sessionScope.role == 0}">
                <div class="form-row">
                    <div class="inputBox">
                        <h3>Name</h3>
                        <input type="text" placeholder="Full name" name="name" required>
                    </div>
                    <div class="inputBox">
                        <h3>Phone</h3>
                        <input type="tel" placeholder="Phone number" name="phone" required>
                    </div>
                </div>
            </c:if>
            <div class="form-row">
                <div class="inputBox">
                    <h3>Room Type</h3>
                    <select name="roomtype" id="room">
                        <c:forEach items="${listR}" var="o">
                            <option value="${o.id}">${o.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="inputBox">
                    <h3>How many</h3>
                    <input type="number" min="1" placeholder="Number of rooms" name="numofroom" required>
                </div>
            </div>

            <div class="form-row">
                <div class="inputBox">
                    <h3>Arrivals</h3>
                    <input type="date" required name="dateS">
                </div>
                <div class="inputBox">
                    <h3>Leaving</h3>
                    <input type="date" required name="dateE">
                </div>
            </div>
            <c:if test="${error != null}">
                <div class="field-text-error">
                    <p>${error}</p>
                </div>
            </c:if>
            <input type="submit" class="btn" value="book now">
        </form>
    </div>
</section>
<!-- book section ends -->

<!-- Hotel detail section starts -->
<section class="hot-hotel " id="hot-hotel">
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

                <a href="#book" class="btn"> Book now</a>
                <a href="LoadMap?lng=${requestScope.location.lng}&lat=${requestScope.location.lat}" class="btn mg-l"> See In Map</a>
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
                <div class="swiper-slide magrin-slide">
                    <div class="box">
                        <img src="${o.images}" alt="room image">
                        <h3>${o.name}</h3>
                        <p>${o.des}</p>
                        <div class="price">${Math.ceil(o.cost*(1-o.discount/100)/24000)} $ <span
                                class="dis">${Math.ceil(o.cost/24000)} $</span><span
                                class="text"> <br> Per Night </span>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>

<!-- Room section ends -->

<%--RATE SECTION STARTS--%>
<section class="rating mb-body" id="rating">
    <h1 class="heading">
        <span>R</span>
        <span>A</span>
        <span>T</span>
        <span>I</span>
        <span>N</span>
        <span>G</span>
    </h1>

    <div class="rate-container">
        <div class="voting-section">
            <h2>Rating of ${hotel_details.name}</h2>
            <div class="number-stars">
                <c:if test="${numofstars != null}">
                    <p>${numofstars} / 5.0</p>

                </c:if>
                <c:if test="${numofstars == null}">
                    <p>0.0 / 5.0</p>

                </c:if>
                <i class="fas fa-star"></i>
            </div>
            <c:if test="${numofrates != null}">
                <p class="number-rates">${numofrates} rates</p>
            </c:if>
            <c:if test="${numofrates == null}">
                <p class="number-rates">0 rates</p>
            </c:if>
            <c:if test="${sessionScope.Account != null}">
                <c:if test="${checkUID == false}">
                    <button class="btn rate-hotel">rate hotel</button>
                </c:if>
                <c:if test="${checkUID == true}">
                    <button class="edit-rate btn">Edit rate</button>
                </c:if>

            </c:if>

        </div>
        <div id="list-cmt" class="reviews-list">
            <h2>List Review</h2>
            <c:forEach items="${listRate}" var="o">
                <div class="num_comment review-item">
                    <div class="review-heading">
                        <div class="row">
                            <i class="user-icon fas fa-user"></i>
                            <h3 class="name">${o.fullname}</h3>
                            <p class="date">${o.date}</p>
                        </div>
                        <c:if test="${o.UID == sessionScope.Account.UID}">
                            <div class="row">
                                <a class="delete-rate icon" href="DeleteRate?id_rate=${o.id_rate}&id_hotel=${o.ID_Hotel}"><i
                                        class="fa-solid fa-trash-can"></i></a>
                            </div>
                        </c:if>
                    </div>
                    <div class="stars">
                        <c:forEach begin="1" end="${o.stars}">
                            <i class="fas fa-star"></i>
                        </c:forEach>
                    </div>
                    <div class="comment">${o.comment}</div>
                </div>
            </c:forEach>

        </div>
        <div class="align-center">
            <button onclick="loadMore()" class="btn load-btn">Load More</button>
        </div>
    </div>
</section>

<div class="vote-conatainer close-btn">
    <form action="AddRate?uid=${sessionScope.Account.UID}&id_hotel=${hotel_details.id}" class="vote-form" method="post">
        <h2>Rating hotel</h2>
        <div class="close-btn"><i class="fas fa-times"></i></div>
        <input value="1" type="radio" id="op-1" name="numofstar">
        <input value="2" type="radio" id="op-2" name="numofstar">
        <input value="3" type="radio" id="op-3" name="numofstar">
        <input value="4" type="radio" id="op-4" name="numofstar">
        <input value="5" type="radio" id="op-5" name="numofstar">
        <label for="op-1" class="option op-1">
            <span>1<i class="fas fa-star"></i></span>
        </label>
        <label for="op-2" class="option op-2">
            <span>2<i class="fas fa-star"></i></span>
        </label>
        <label for="op-3" class="option op-3">
            <span>3<i class="fas fa-star"></i></span>
        </label>
        <label for="op-4" class="option op-4">
            <span>4<i class="fas fa-star"></i></span>
        </label>
        <label for="op-5" class="option op-5">
            <span>5<i class="fas fa-star"></i></span>
        </label>
        <textarea name="comment" class="input-box" rows="3" placeholder="Comment here..."></textarea>
        <input value="Rate" type="submit" class="btn">
    </form>
</div>

<div class="edit-conatainer close-btn">
    <form action="EditRate?uid=${sessionScope.Account.UID}&id_hotel=${hotel_details.id}" class="vote-form" method="post">
        <h2>Edit Rate</h2>
        <div class="close-btn"><i class="fas fa-times"></i></div>
        <input value="1" type="radio" id="op-e1" name="numofstar" required>
        <input value="2" type="radio" id="op-e2" name="numofstar" required>
        <input value="3" type="radio" id="op-e3" name="numofstar" required>
        <input value="4" type="radio" id="op-e4" name="numofstar" required>
        <input value="5" type="radio" id="op-e5" name="numofstar" required>
        <label for="op-e1" class="option op-1">
            <span>1<i class="fas fa-star"></i></span>
        </label>
        <label for="op-e2" class="option op-2">
            <span>2<i class="fas fa-star"></i></span>
        </label>
        <label for="op-e3" class="option op-3">
            <span>3<i class="fas fa-star"></i></span>
        </label>
        <label for="op-e4" class="option op-4">
            <span>4<i class="fas fa-star"></i></span>
        </label>
        <label for="op-e5" class="option op-5">
            <span>5<i class="fas fa-star"></i></span>
        </label>
        <textarea name="comment" class="input-box" rows="3" placeholder="Comment here..."></textarea>
        <input value="Edit" type="submit" class="btn">
    </form>
</div>
<%--RATE SECTION ENDS--%>

<!--footer section starts-->
<jsp:include page="footer.jsp"></jsp:include>

<!--footer section ends-->
<script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
        integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<!-- custome js file link -->
<script src="./js/slider.js" type="text/javascript"></script>
<script src="./js/rate.js"></script>
<input type="hidden" value="${hotel_details.id}" id="idhotel">
<script>
    function loadMore() {
        var amount = document.getElementsByClassName("num_comment").length;
        var idhotel = $("#idhotel").val();
        $.ajax({
            url: '/Trividi_Project/LoadComment',
            type: 'get',
            data: {
                amount_cmt: amount,
                id_hotel: idhotel
            },
            success: function (data) {
                var list = document.getElementById("list-cmt")
                list.innerHTML += data;
            },
            error: function () {
                alert("error");
            }
        });
    }
</script>
</body>

</html>
