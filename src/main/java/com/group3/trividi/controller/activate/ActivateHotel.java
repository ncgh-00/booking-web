package com.group3.trividi.controller.activate;

import com.group3.trividi.dao.Hotel_DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ActivateHotel", value = "/ActivateHotel")
public class ActivateHotel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        String ac = request.getParameter("check");
        Hotel_DAO hotel = new Hotel_DAO();
        if (ac.equals("true")) {
            hotel.activate(Integer.parseInt(id), true);
        } else {
            hotel.activate(Integer.parseInt(id), false);
        }
        String page = request.getParameter("page");
        response.sendRedirect(page);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
