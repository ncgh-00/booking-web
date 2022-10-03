package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.Hotel_DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddRoom", value = "/AddRoom")
public class AddRoom extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idh = request.getParameter("idh");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        String cost = request.getParameter("cost");
        String discount = request.getParameter("discount");
        Hotel_DAO dao = new Hotel_DAO();
        System.out.println("id hotel ne nhe: "+idh);
        dao.addRoom(idh, name, image, description, cost, discount);
        response.sendRedirect("LoadMyHotel");

    }
}
