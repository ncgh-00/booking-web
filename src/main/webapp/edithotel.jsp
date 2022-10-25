<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Hotel</title>
    <link rel="icon" type="image/x-icon" href="./images/logo.svg">
    <link rel="stylesheet" href="css/form-xl.css">
</head>
<body>
<div class="layout">
    <div class="container">
        <h3 class="heading">Edit Hotel</h3>
        <form action="EditHotel" class="form" method="post" enctype="multipart/form-data">
            <input type="hidden" class="input-box" name="idhotel" value="${hotel.id}">
            <div class="input">
                <input type="text" class="input-box" placeholder="Hotel Name" name="name" value="${hotel.name}">
            </div>

            <div class="input">
                <textarea class="input-box" name="description" placeholder="Description" rows="2">${hotel.des}</textarea>
            </div>

            <div class="input">
                <select name="category" id="category" class="input-box">
                    <option value="" selected>Select Category</option>
                    <c:forEach items="${sessionScope.Category}" var="o">
                        <option value="${o.id}" ${hotel.category == o.name? "selected" : ""}>${o.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="input">
                <input type="file" class="input-box" name="image">
            </div>

            <div class="input">
                <input type="tel" class="input-box" placeholder="Phone" name="phone" value="${hotel.phone}">
            </div>

            <div class="input">
                <input type="text" class="input-box" placeholder="Address" name="address" value="${hotel.address}">
            </div>

            <div class="input">
                <input type="number" min="1" max="5" class="input-box" placeholder="Number of star" name="numOfStar" value="${hotel.star}">
            </div>

            <div class="input">
                <select name="city" id="city" class="input-box">
                    <option value="">Select City</option>
                    <c:forEach items="${sessionScope.city}" var="o">
                        <option value="${o.id}" ${hotel.city == o.name?"selected":""}>${o.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="input">
                <input type="text" class="input-box" placeholder="LNG" name="lng">
            </div>

            <div class="input">
                <input type="text" class="input-box" placeholder="LAT" name="lat">
            </div>

            <c:if test="${error != null}">
                <div class="field-text-error">
                    <p>${error}</p>
                </div>
            </c:if>

            <input type="submit" value="Edit" class="btn">

        </form>
    </div>
</div>
</body>
</html>