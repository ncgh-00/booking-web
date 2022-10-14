<%--
  Created by IntelliJ IDEA.
  User: Enalis
  Date: 10/10/2022
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Map</title>
    <link rel="icon" type="image/x-icon" href="./images/logo.svg">
    <meta name="robots" content="noindex, nofollow"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link
            href="https://api.mapbox.com/mapbox-assembly/v1.3.0/assembly.min.css"
            rel="stylesheet"
    />
    <script src="https://api.tiles.mapbox.com/mapbox-gl-js/v2.9.2/mapbox-gl.js"></script>
<%--    <link--%>
<%--            href="https://api.tiles.mapbox.com/mapbox-gl-js/v2.9.2/mapbox-gl.css"--%>
<%--            rel="stylesheet"--%>
<%--    />--%>
    <script src="https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-directions/v3.1.1/mapbox-gl-directions.js"></script>
    <link
            rel="stylesheet"
            href="https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-directions/v3.1.1/mapbox-gl-directions.css"
            type="text/css"
    />
    <link href="https://api.mapbox.com/mapbox-gl-js/v2.9.2/mapbox-gl.css" rel="stylesheet">
    <style>
        body {
            margin: 0;
            padding: 0;
        }
        .marker {
            background-image: url('/Trividi_Project/images/logo.svg');
            background-color: rgba(246, 162, 81, 0);
            background-size: cover;
            width: 45px;
            height: 45px;
            border-radius: 50%;
            cursor: pointer;
        }

        #geocoder-container > div {
            min-width: 50%;
            margin-left: 25%;
        }

        .string {
            color: #314ccd;
        }

        .number {
            color: #b43b71;
        }

        .boolean {
            color: #5a3fc0;
        }

        .null {
            color: #ba7334;
        }

        .key {
            color: #ba3b3f;
        }
    </style>
    <script src="https://js.sentry-cdn.com/9c5feb5b248b49f79a585804c259febc.min.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="flex h-viewport-full relative overflow-hidden">
    <div
            class="flex-child-grow bg-white h-viewport-2/3 h-viewport-full-mm"
            id="map"
    ></div>
</div>

<script>
    mapboxgl.accessToken = 'pk.eyJ1IjoicGhvbmdiaW5odHJhbiIsImEiOiJjbDk1cXNwa3QwMWtxM291bmZneGRkYWg0In0.Tt1Ipv9H5OWHQmrYz0REUw';

        <c:if test="${requestScope.lng == null || requestScope.lat == null }">
            const map = new mapboxgl.Map({
                container: 'map',
                style: 'mapbox://styles/phongbinhtran/cl91jrxll003316o7q0b7awxi',
                center: [108.33901399926685,15.28257503710688],
                zoom: 7,
                projector: 'mercator'
             });
        </c:if>

    <c:if test="${requestScope.lng != null || requestScope.lat != null }">
    const map = new mapboxgl.Map({
        container: 'map',
        style: 'mapbox://styles/phongbinhtran/cl91jrxll003316o7q0b7awxi',
        center: [<c:out value="${requestScope.lng}"/>,<c:out value="${requestScope.lat}"/>],
        zoom: 20,
        projector: 'mercator'
    });
    </c:if>




    <c:if test="${requestScope.list.size() != 0}">
        var data = [
            <c:forEach items="${requestScope.list}" var="o">
                ['<c:out value="${o.name}"/>',<c:out value="${o.id_hotel}"/>,<c:out value="${o.lng}"/>,<c:out value="${o.lat}"/>,'<c:out value="${o.link}"/>'],
            </c:forEach>
            []
        ];
    var el;


        for(let i = 0 ; i < data.length -1 ; i++){
            el = document.createElement('div');
            el.className = 'marker';
            new mapboxgl.Marker(el)
                .setLngLat([data[i][2],data[i][3]])
                .setPopup(new mapboxgl.Popup().setHTML("<div style='align-content: center;width: 160px;height: 180px'><a href="+"'LoadBooking?id="+data[i][1]+"'>"+data[i][0]+"</a><img src='"+data[i][4]+"'width='150' height='150'></div>"))
                .addTo(map);
        }




<%--        <c:forEach var="o" items="${requestScope.list}" varStatus="loop">--%>

<%--            const marker<c:out value="${loop.index}"/> = new mapboxgl.Marker()--%>
<%--                .setLngLat([o.lng,o.lat])--%>
<%--                .setPopup(new mapboxgl.Popup().setHTML("<a href='LoadBooking?id=${o.id_hotel}'>${o.name}</a>"))--%>
<%--                .addTo(map);--%>

<%--        </c:forEach>--%>
    </c:if>

    const directions = new MapboxDirections({
        accessToken: mapboxgl.accessToken,
        steps: false,
        geometries: 'polyline',
        controls: {instructions: false}
    });

    map.addControl(directions, 'top-right');

    // After the map style has loaded on the page, add a source layer and default
    // styling for a single point.


    map.addControl(
        new mapboxgl.GeolocateControl({
            positionOptions: {
                enableHighAccuracy: true
            },
            // When active the map will receive updates to the device's location as it changes.
            trackUserLocation: true,
            // Draw an arrow next to the location dot to indicate which direction the device is heading.
            showUserHeading: true
        })
    );
</script>
</body>
</html>
