<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Hotel For Staff</title>
    <link rel="stylesheet" href="css/form-l.css">
</head>
<body>
<div class="layout">
    <div class="container">
        <h3 class="heading">Edit Hotel</h3>
        <form action="AddHotelForStaff" class="form" method="post">
            <input type="hidden" class="input-box" name="staffid" value="<%=request.getParameter("staffid")%>">

            <div class="input">
                <select name="idhotel" class="input-box">
                    <option value="" selected>Select Hotel</option>
                    <c:forEach items="${listH}" var="o">
                        <option value="${o.id}">${o.name}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="submit" value="Add" class="btn">
        </form>
    </div>
</div>
</body>
</html>