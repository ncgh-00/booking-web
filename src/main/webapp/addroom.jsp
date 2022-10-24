<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Room</title>
    <link rel="icon" type="image/x-icon" href="./images/logo.svg">
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="css/form-l.css">
</head>
<body>
<div class="layout">
    <div class="container">

        <h3 class="heading">Add Room</h3>
        <form action="AddRoom?idh=<%=request.getParameter("idh")%>" class="form" method="post" enctype="multipart/form-data">

            <div class="input">
                <input type="text" class="input-box" placeholder="Name of room" name="name" required>
            </div>

            <div class="input">
                <input type="file" class="input-box" title="Choose file" name="image" required>
            </div>


            <div class="input">
                <input type="number" class="input-box" placeholder="Cost" name="cost" min="1" required>
            </div>

            <div class="input">
                <input type="number" class="input-box" placeholder="Discount" name="discount" min="0" required>
            </div>

            <div class="input">
                <textarea class="input-box" name="description" placeholder="Description" rows="2" required></textarea>
            </div>

            <input type="submit" value="Add" class="btn">
        </form>
    </div>
</div>
</body>
</html>