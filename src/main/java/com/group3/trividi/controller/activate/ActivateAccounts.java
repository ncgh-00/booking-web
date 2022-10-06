package com.group3.trividi.controller.activate;

import com.group3.trividi.dao.Hotel_DAO;
import com.group3.trividi.dao.User_DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ActivateAccounts", value = "/ActivateAccounts")
public class ActivateAccounts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String uid = request.getParameter("uid");
        String ac = request.getParameter("check");
        User_DAO account = new User_DAO();
        if (ac.equals("true")) {
            account.activate(uid, true);
        } else {
            account.activate(uid, false);
        }
        String page = request.getParameter("page");
        response.sendRedirect(page);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
