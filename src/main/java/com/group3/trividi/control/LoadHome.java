package com.group3.trividi.control;


import com.group3.trividi.dao.City_DAO;
import com.group3.trividi.dao.Hotel_DAO;
import com.group3.trividi.model.City;
import com.group3.trividi.model.Hotel_Details;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadHome", value = "/index.jsp")
public class LoadHome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Hotel_DAO hotel = new Hotel_DAO();
        List<Hotel_Details> listH = hotel.getHotelsInHome();
        request.setAttribute("listH", listH); // EL ${list}
        City_DAO city = new City_DAO();
        List<City> listC = city.getCitys();
        request.setAttribute("listC", listC); // EL ${list}
//        request.setAttribute("page", "index.jsp");
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
