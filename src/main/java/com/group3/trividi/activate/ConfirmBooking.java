package com.group3.trividi.activate;

import com.group3.trividi.dao.Booking_DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ConfirmBooking", value = "/ConfirmBooking")
public class ConfirmBooking extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String id_staff = request.getParameter("id_staff");
        String check = request.getParameter("check");
        String page = request.getParameter("page");
        Booking_DAO dao = new Booking_DAO();
        if(check.equalsIgnoreCase("false")){
            dao.activate(id, false, id_staff);
        }else{
            dao.activate(id, true, id_staff);
        }
        response.sendRedirect(page);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
