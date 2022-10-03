package com.group3.trividi.controller.load;

import com.group3.trividi.dao.Hotel_DAO;
import com.group3.trividi.model.Hotel_Details;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Search", value = "/Search")
public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("hotel");
        String greater = request.getParameter("cost_filter");
        String city = request.getParameter("search-by-city");
        String cate = request.getParameter("search-by-category");

        String cost = request.getParameter("cost");
        int price = -1;
        if( cost != null) price = 24000*Integer.parseInt(cost);
        Hotel_DAO dao = new Hotel_DAO();
        List<Hotel_Details> ls = dao.searchHotels(name,city,cate,price,greater);
        request.setAttribute("hotel_details",ls);

        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
