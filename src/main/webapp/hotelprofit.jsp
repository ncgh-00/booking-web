<%@ page import="com.group3.trividi.dao.Statistic_DAO" %>

<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profit of hotel</title>
    <link rel="icon" type="image/x-icon" href="./images/logo.svg">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/dashboard.css">
    <script src="https://www.gstatic.com/charts/loader.js"></script>
    <script>

        google.charts.load('current', {'packages': ['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {

            var data = google.visualization.arrayToDataTable([
                ['Time', 'Number of Books','Dollar']
                <c:forEach items="${requestScope.map}" var="o">
                ,['<c:out value="${o.key}"/>',<c:out value="${o.value.numberBooks}"/>,<c:out value="${o.value.total}"/>]
                </c:forEach>
            ]);

            var options = {
                title: 'Trividi Performance',
                hAxis: {title: 'Timeline'},
                vAxis: {title: 'Profit'},
                seriesType: 'bars',
                series: {1: {type: 'line'},
                    legend: {position: 'top', textStyle: {color: 'blue', fontSize: 16}}}
            };
            <c:if test="${requestScope.map.size() > 0}">
            <c:out value="var chart = new google.visualization.ComboChart(document.getElementById('chart'));
            chart.draw(data, options);" escapeXml="false"/>
            </c:if>

        }
    </script>
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="card-container mt-10">
    <div class="card card-orange">
        <div class="card__heading">
            <div class="card__content">
                <h3 class="card__number">$</h3>
                <p class="card__details">all profits</p>
            </div>
            <div class="card__icon"><i class="fa-solid fa-money-bill-trend-up"></i></div>
        </div>
        <div class="line"></div>
        <div class="card__footer">
            <i class="fa-regular fa-clock"></i>
            <p class="card_time">update: </p>
        </div>
    </div>

    <div class="card card-green">
        <div class="card__heading">
            <div class="card__content">
                <h3 class="card__number"></h3>
                <p class="card__details">all bookings</p>
            </div>
            <div class="card__icon"><i class="fa-solid fa-rectangle-list"></i></div>
        </div>
        <div class="line"></div>
        <div class="card__footer">
            <i class="fa-regular fa-clock"></i>
            <p class="card_time">update: </p>
        </div>
    </div>

    <div class="card card-red">
        <div class="card__heading">
            <div class="card__content">
                <h3 class="card__number">$</h3>
                <p class="card__details">Day's profits</p>
            </div>
            <div class="card__icon"><i class="fa-solid fa-money-bill-trend-up"></i></div>
        </div>
        <div class="line"></div>
        <div class="card__footer">
            <i class="fa-regular fa-clock"></i>
            <p class="card_time"> update: </p>
        </div>
    </div>

    <div class="card card-blue">
        <div class="card__heading">
            <div class="card__content">
                <h3 class="card__number"></h3>
                <p class="card__details">Day's bookings</p>
            </div>
            <div class="card__icon"><i class="fa-solid fa-rectangle-list"></i></div>
        </div>
        <div class="line"></div>
        <div class="card__footer">
            <i class="fa-regular fa-clock"></i>
            <p class="card_time"> update: </p>
        </div>
    </div>
</div>

<form action="" class="form-search">
    <input oninput="checkRequired(this)" type="number" class="search-bar" placeholder="Month" min="1" max="12" name="month">
    <input id="year" type="number" class="search-bar" placeholder="Year" min="2022" name="year">

    <input type="submit" value="View" class="btn">
</form>
<div class="chart-container">
    <c:if test="${requestScope.map.size() == 0}">
        <div class="notification">This time dose not have any Book!</div>
    </c:if>
    <div id="chart">
    </div>

</div>


<jsp:include page="footer.jsp"></jsp:include>

<script>
    function checkRequired(input) {
        var text = input.value;
        const year = document.getElementById("year")
        const attr = document.createAttribute("required");
        if(text != ""){
            year.setAttributeNode(attr);
        }
    }
</script>
</body>

</html>