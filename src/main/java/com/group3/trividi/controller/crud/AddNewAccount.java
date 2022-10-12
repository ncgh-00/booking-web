package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.model.Account_Info;
import com.group3.trividi.utils.HashPassword;
import com.group3.trividi.utils.NameGenerator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddNewAccount", value = "/AddNewAccount")
public class AddNewAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = NameGenerator.randomIdentifier();
        String pass = HashPassword.generatePassword(8);
        System.out.println("user name:" +username);
        System.out.println("pass :" +pass);

        User_DAO dao = new User_DAO();
        dao.randomUser(3, username, pass);
        request.setAttribute("username", username);
        request.setAttribute("pass",pass);
        request.setAttribute("show",1);
        request.getRequestDispatcher("LoadAccounts").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
