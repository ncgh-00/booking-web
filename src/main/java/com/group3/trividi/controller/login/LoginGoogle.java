package com.group3.trividi.controller.login;


import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.google.GooglePojo;
import com.group3.trividi.google.GoogleUtils;
import com.group3.trividi.model.Account;
import com.group3.trividi.utils.StringCutter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginGoogle", value = "/LoginGoogle")
public class LoginGoogle extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public LoginGoogle(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        System.out.println(code);
        if (code == null || code.isEmpty()) {

            RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
            dis.forward(request, response);
        } else {
            String accessToken = GoogleUtils.getToken(code);
            GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);

            User_DAO dao = new User_DAO();
            Account acc = dao.getUserByEmail(googlePojo.getEmail());
            HttpSession session = request.getSession();
            if(acc == null){
                dao.insert(googlePojo.getEmail(), googlePojo.getGiven_name());
                acc = dao.getUserByEmail(googlePojo.getEmail());
            }
            System.out.println(StringCutter.cut(acc.getFullname()));
            session.setAttribute("name", StringCutter.cut(acc.getFullname()));
            session.setAttribute("Account", acc);
            session.setAttribute("role", acc.getRoleID());
            RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
            dis.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
