<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<section class="footer">
    <div class="box-container">
        <div class="box">
            <h3>about us</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Totam natus asperiores voluptas aliquam vitae odio. Beatae doloribus facere nostrum magni.</p>
        </div>
        <div class="box">
            <h3>Locations</h3>
            <c:forEach items="${listC}" var="o">
<%--            <a href="LoadHome?id=${o.id}">${o.name}</a>--%>
                <a href="Search?search-by-city=${o.name}">${o.name}</a>
            </c:forEach>
<%--            <c:forEach items="${listC}" var="o">--%>

<%--                    <img src="${o.link_images}" alt="">--%>
<%--                    <div class="content">--%>
<%--                        <h3>${o.name}</h3>--%>

<%--                        <a href="Search?search-by-city=${o.name}" class="btn">see more</a>--%>


<%--                </div>--%>
<%--            </c:forEach>--%>
        </div>

        <div class="box">
            <h3>follow us</h3>
            <a href="https://www.facebook.com/profile.php?id=100074870037080">facebook</a>
            <a href="https://www.instagram.com/nqkhang.28/">instagram</a>
            <a href="https://github.com/ncgh-00/booking-web.git">github</a>
            <a href="#">#</a>
        </div>s
    </div>
    <h1 class="credit"> created by <span>group 3</span> | enjoy your trip!! </h1>
</section>
