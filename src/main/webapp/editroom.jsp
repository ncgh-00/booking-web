<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Hotel</title>
    <link rel="stylesheet" href="css/form-s.css">
</head>
<body>
<div class="layout">
    <div class="container">
        <h3 class="heading">Edit Hotel</h3>

        <form action="EditRoom" class="form" method="post" enctype="multipart/form-data">
            <input type="hidden" class="input-box" name="idroom" value="<%=request.getParameter("idr")%>" >
            <div class="input">
                <input type="text" class="input-box" placeholder="Name of room" name="name">
            </div>

            <div class="input">
                <textarea class="input-box" name="description" placeholder="Description" rows="2"></textarea>
            </div>
            <div class="input">
                <input type="file" class="input-box" title="Choose file" name="image">
            </div>

            <div class="input">
                <input type="number" min="1" class="input-box" placeholder="Cost" name="cost">
            </div>

            <div class="input">
                <input type="number" min="0" class="input-box" placeholder="Discount" name="discount">
            </div>

            <input type="submit" value="Edit" class="btn">
        </form>
    </div>
</div>
</body>
</html>