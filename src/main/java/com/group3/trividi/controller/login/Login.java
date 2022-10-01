package com.group3.trividi.controller.login;

import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.model.Account;
import com.group3.trividi.utils.HashPassword;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String page = request.getParameter("page");
        String id_hotel = request.getParameter("id_hotel");
        HttpSession session = request.getSession();
        User_DAO dao = new User_DAO();
        Account acc = dao.getUSer(username, HashPassword.getHashedPassword(password));
        System.out.println(acc);
        if (acc == null) {
            request.setAttribute("error", "Username or password is not valid!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            session.setAttribute("role", 0);

        }else if(!acc.isStatus()){
            request.setAttribute("error", "Account is blocked! ");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            session.setAttribute("role", 0);
        }

        else {
            request.removeAttribute("error");
            session.setAttribute("Account", acc);
            session.setAttribute("role", acc.getRoleID());
            request.setAttribute("id_hotel",id_hotel);
            if(page == null || page.equals("null")){
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}