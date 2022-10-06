package com.group3.trividi.controller.load;

import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.model.Account_Info;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadAccounts", value = "/LoadAccounts")
public class LoadAccounts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User_DAO dao = new User_DAO();
        List<Account_Info> list = dao.getUsersInfo();
        request.setAttribute("ListA", list);
        request.getRequestDispatcher("manageaccount.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
