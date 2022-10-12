package com.group3.trividi.controller.load;

import com.group3.trividi.dao.Hotel_DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoadMap", value = "/LoadMap")
public class LoadMap extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Hotel_DAO dao = new Hotel_DAO();
        request.setAttribute("list", dao.getMaps());
        String lng = request.getParameter("lng");
        String lat = request.getParameter("lat");

        request.setAttribute("lng", lng);
        request.setAttribute("lat", lat);

        request.getRequestDispatcher("map.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
