package com.group3.trividi.controller.activate;

import com.group3.trividi.dao.Hotel_DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ActivateRoom", value = "/ActivateRoom")
public class ActivateRoom extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        String ac = request.getParameter("check");
        String position = request.getParameter("pageposition");
        Hotel_DAO accRoom = new Hotel_DAO();
        if (ac.equals("true")) {
            accRoom.activateRoom(Integer.parseInt(id), true);
        } else {
            accRoom.activateRoom(Integer.parseInt(id), false);
        }
        String page = request.getParameter("page");
        response.sendRedirect(position==null?page:page+position);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
