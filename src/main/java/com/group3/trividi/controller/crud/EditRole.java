package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.User_DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditRole", value = "/EditRole")
public class EditRole extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String role = request.getParameter("role");


        User_DAO dao = new User_DAO();
        dao.editRole(id, role);
        response.sendRedirect("LoadAccounts");

    }
}
