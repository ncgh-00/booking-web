<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <header>
            <div id="menu-bar" class="fas fa-bars"></div>

            <a href="#" class="logo"><span>T</span>rividi</a>


        <c:if test="${sessionScope.Account == null || sessionScope.role == 0}">
            <nav class="navbar">
                <a href="index.jsp">home</a>
                <c:if test="${requestScope.page == 'index.jsp' }">
                <a href="#city">city</a>
                <a href="#services">services</a>
                </c:if>
                <c:if test="${requestScope.page == 'LoadBooking' }">
                    <a href="#city">Room</a>
                    <a href="#services">Book</a>
                </c:if>
                <a href="#contact">contact</a>
            </nav>

            <div class="icons">
                 <c:if test="${requestScope.page == 'index.jsp' }">
                <i class="fas fa-search" id="search-btn"></i>
                </c:if>
                <a href="login.jsp?page=${requestScope.page}&&id_hotel=${requestScope.id_hotel}"><i class="fas fa-user" id="login-btn"></i></a>
            </div>
        </c:if>

         <c:if test="${sessionScope.role == 1  && sessionScope.Account.fullname != null}">
             <nav class="navbar">
                 <a href="index.jsp">home</a>
                 <c:if test="${requestScope.page == 'index.jsp' }">
                     <a href="#city">city</a>
                     <a href="#services">services</a>
                 </c:if>
                 <c:if test="${requestScope.page == 'LoadBooking' }">
                     <a href="#city">Room</a>
                     <a href="#services">Book</a>
                 </c:if>
                 <a href="#">Dashboard</a>
                 <a href="#">My account</a>
                 <a href="#contact">contact</a>
             </nav>

             <div class="icons">
                 <c:if test="${requestScope.page == 'index.jsp' }">
                     <i class="fas fa-search" id="search-btn"></i>
                 </c:if>
                 <a href="Logout?page=${requestScope.page}&&id_hotel=${requestScope.id_hotel}"><i class="fas fa-sign-out-alt"></i></a>
             </div>
         </c:if>

     <c:if test="${sessionScope.role == 2  && sessionScope.Account.fullname != null}">
         <nav class="navbar">
             <a href="index.jsp">home</a>
             <c:if test="${requestScope.page == 'index.jsp' }">
                 <a href="#city">city</a>
                 <a href="#services">services</a>
             </c:if>
             <c:if test="${requestScope.page == 'LoadBooking' }">
                 <a href="#city">Room</a>
                 <a href="#services">Book</a>
             </c:if>
             <a href="LoadMyAccount">My account</a>
             <a href="MyHotel">My hotel</a>
             <a href="#contact">contact</a>
         </nav>

         <div class="username">
             <a href="#">${sessionScope.Account.fullname}</a>
         </div>

         <div class="icons">
             <c:if test="${requestScope.page == 'index.jsp' }">
                 <i class="fas fa-search" id="search-btn"></i>
             </c:if>
             <a href="Logout?page=${requestScope.page}&&id_hotel=${requestScope.id_hotel}"><i class="fas fa-sign-out-alt" ></i></a>
         </div>
     </c:if>

     <c:if test="${sessionScope.role == 3  && sessionScope.Account.fullname != null}">
         <nav class="navbar">
             <a href="index.jsp">home</a>
             <c:if test="${requestScope.page == 'index.jsp' }">
                 <a href="#city">city</a>
                 <a href="#services">services</a>
             </c:if>
             <c:if test="${requestScope.page == 'LoadBooking' }">
                 <a href="#city">Room</a>
                 <a href="#services">Book</a>
             </c:if>
             <a href="LoadMyAccount">My account</a>
             <a href="#contact">contact</a>
         </nav>

         <div class="username">
             <a href="#">${sessionScope.Account.fullname}</a>
         </div>

         <div class="icons">
             <c:if test="${requestScope.page == 'index.jsp' }">
                 <i class="fas fa-search" id="search-btn"></i>
             </c:if>
             <a href="Logout?page=${requestScope.page}&&id_hotel=${requestScope.id_hotel}"><i class="fas fa-sign-out-alt" ></i></a>
         </div>
     </c:if>

            <form action="" class="search-bar-container">
                <p>Search bar</p>
                <div class="row">
                    <input type="text" id="search-bar-1" placeholder="search here...">
                    <div class="col">
                        <select name="search-by" id="xx">
                            <option value="city">[Search City]</option>
                            <option value="hotel" selected>[Search Hotel]</option>
                            <option value="city">[Search City]</option>
                        </select>
                        <select name="search-by" id="x">
                            <option value="hotel" selected>[Search Hotel]</option>
                            <option value="city">[Search City]</option>
                        </select>
                        <button class="search-btn" type="submit"><label for="search-bar-1" class="fas fa-search"></label></button>
                    </div>
                </div>

                <p>Cost filter</p>
                <div class="row">
                    <input type="number" min="0" id="search-bar-2" placeholder="search here...">

                    <div class="col">
                        <input type="radio" id="option-1" name="cost_filter" >
                        <input type="radio" id="option-2" name="cost_filter">
                        <label for="option-1" class="option option-1">
                            <div class="dot"></div>
                            <span>Greater</span>
                        </label>
                        <label for="option-2" class="option option-2">
                            <div class="dot"></div>
                            <span>Less</span>
                        </label>
                    </div>
                </div>
            </form>
        </header>
