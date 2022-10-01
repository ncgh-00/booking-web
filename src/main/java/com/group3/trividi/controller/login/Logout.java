package com.group3.trividi.controller.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Logout", value = "/Logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String page = request.getParameter("page");
        String id_hotel = request.getParameter("id_hotel");
        session.removeAttribute("role");
        session.removeAttribute("Account");
        request.setAttribute("id_hotel",id_hotel);
        if(page == null || page.equals("null")){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else
            request.getRequestDispatcher(page).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
