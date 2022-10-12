package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.Rate_DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteRate", value = "/DeleteRate")
public class DeleteRate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Rate_DAO dao = new Rate_DAO();
        String id_rate = request.getParameter("id_rate");
        String id_hotel = request.getParameter("id_hotel");
        System.out.println(id_rate);
        System.out.println(id_hotel);
        dao.DeleteRate(id_rate);

        request.getRequestDispatcher("LoadBooking?id="+id_hotel).forward(request,response);




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
