package com.group3.trividi.activate;

import com.group3.trividi.dao.Hotel_DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ActivateRoom", value = "/ActivateRoom")
public class ActivateRoom extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        String ac = request.getParameter("check");
        Hotel_DAO accRoom = new Hotel_DAO();
        if (ac.equals("true")) {
            accRoom.activateRoom(Integer.parseInt(id), true);
        } else {
            accRoom.activateRoom(Integer.parseInt(id), false);
        }
        String page = request.getParameter("page");
        response.sendRedirect(page);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
