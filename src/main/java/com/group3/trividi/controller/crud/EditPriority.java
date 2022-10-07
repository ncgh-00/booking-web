package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.Hotel_DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditPriority", value = "/EditPriority")
public class EditPriority extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String priority = request.getParameter("priority");

        Hotel_DAO dao = new Hotel_DAO();
        dao.editPriority(id, priority);
        response.sendRedirect("LoadHotels");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
