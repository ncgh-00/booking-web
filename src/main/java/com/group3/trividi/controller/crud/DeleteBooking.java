package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.Booking_DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteBooking", value = "/DeleteBooking")
public class DeleteBooking extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("huy o day");
        Booking_DAO dao = new Booking_DAO();
        String id  = request.getParameter("id");
        String page = request.getParameter("page");
        dao.deleteBook(id);
        response.sendRedirect(page);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
