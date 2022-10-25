package com.group3.trividi.controller.load;


import com.group3.trividi.dao.City_DAO;
import com.group3.trividi.dao.Hotel_DAO;
import com.group3.trividi.model.City;
import com.group3.trividi.model.Hotel_Category;
import com.group3.trividi.model.Hotel_Details;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadHome", value = "/index.jsp")
public class LoadHome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Hotel_DAO hotel = new Hotel_DAO();
        List<Hotel_Details> listH = hotel.getHotelsInHome();
        request.setAttribute("listH", listH); // EL ${list}
        City_DAO city = new City_DAO();
        List<City> listC = city.getCitys();
        List<Hotel_Category> cate =  hotel.getCategory();
        HttpSession session = request.getSession();
        session.setAttribute("Category",cate);
        session.setAttribute("city",listC);
        request.setAttribute("page", "index.jsp");
        Hotel_Details hotel_details = hotel.getHotHotel();
        request.setAttribute("hotel_details", hotel_details);

        request.getRequestDispatcher("home.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
