package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.Rate_DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditRate", value = "/EditRate")
public class EditRate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String uid = request.getParameter("uid");
        String id_hotel = request.getParameter("id_hotel");
        String numofstar = request.getParameter("numofstar");
        String comment = request.getParameter("comment");

        Rate_DAO dao = new Rate_DAO();
        dao.editRate(numofstar,comment,uid,id_hotel);
//        request.setAttribute("id",id_hotel);
        request.getRequestDispatcher("LoadBooking?id="+id_hotel).forward(request,response);


    }
}
