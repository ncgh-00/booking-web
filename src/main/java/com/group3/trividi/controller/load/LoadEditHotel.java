package com.group3.trividi.controller.load;

import com.group3.trividi.dao.City_DAO;
import com.group3.trividi.dao.Hotel_DAO;
import com.group3.trividi.model.City;
import com.group3.trividi.model.Hotel_Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoadEditHotel", value = "/LoadEditHotel")
public class LoadEditHotel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Hotel_DAO hotel = new Hotel_DAO();
        City_DAO city = new City_DAO();

        List<Hotel_Category> category = hotel.getCategory();
        request.setAttribute("category", category);

        List<City> cityList = city.getCitys();
        request.setAttribute("cityList", cityList);

        request.getRequestDispatcher("edithotel.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
