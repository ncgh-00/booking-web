package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.Rate_DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddRate", value = "/AddRate")
public class AddRate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid  = request.getParameter("uid");
        String id_hotel = request.getParameter("id_hotel");
        String cmt = request.getParameter("cmt");
        int stars = Integer.parseInt(request.getParameter("stars"));

        Rate_DAO dao = new Rate_DAO();
        dao.addRate(uid, id_hotel,cmt,stars);
        response.sendRedirect("LoadBooking");
    }
}
