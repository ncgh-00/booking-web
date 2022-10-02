package com.group3.trividi.activate;

import com.group3.trividi.dao.Hotel_DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ActivateHotel", value = "/ActivateHotel")
public class ActivateHotel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        String ac = request.getParameter("check");
        Hotel_DAO hotel = new Hotel_DAO();
        if (ac.equals("true")) {
            hotel.activate(Integer.parseInt(id), true);
        } else {
            hotel.activate(Integer.parseInt(id), false);
        }

        response.sendRedirect("LoadMyHotel");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
