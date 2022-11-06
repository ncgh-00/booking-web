package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.Rate_DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddRate", value = "/AddRate")
public class AddRate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id_hotel = request.getParameter("id_hotel");
        String cmt = request.getParameter("comment");
        int stars = Integer.parseInt(request.getParameter("numofstar"));
        String uid  = request.getParameter("uid");
        System.out.println(id_hotel + " " + cmt +  " " + stars + " " + uid );
        Rate_DAO dao = new Rate_DAO();
        dao.addRate(uid, id_hotel, "N'"+cmt+"'", stars);
//        request.setAttribute("id", id_hotel);
        request.getRequestDispatcher("LoadBooking?id="+id_hotel).forward(request,response);
    }
}
