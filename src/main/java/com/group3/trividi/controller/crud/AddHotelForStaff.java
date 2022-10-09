package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.User_DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddHotelForStaff", value = "/AddHotelForStaff")
public class AddHotelForStaff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String staffid = request.getParameter("staffid");
        String idH = request.getParameter("idhotel");

        User_DAO dao = new User_DAO();
        dao.addHotelforStaff(staffid, idH);
        response.sendRedirect("LoadAccounts");

    }
}
