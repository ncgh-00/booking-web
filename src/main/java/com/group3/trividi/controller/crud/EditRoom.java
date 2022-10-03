package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.Hotel_DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditRoom", value = "/EditRoom")
public class EditRoom extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        String des = request.getParameter("description");
        String cost = request.getParameter("cost");
        String discount = request.getParameter("discount");
        Hotel_DAO dao = new Hotel_DAO();

        String idr = request.getParameter("idroom");

        dao.editRoom(idr, name,des, cost, discount);
        response.sendRedirect("LoadMyHotel");
    }
}
