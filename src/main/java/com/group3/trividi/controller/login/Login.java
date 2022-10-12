package com.group3.trividi.controller.login;

import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.model.Account;
import com.group3.trividi.utils.HashPassword;
import com.group3.trividi.utils.StringCutter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
        String id_hotel = request.getParameter("id");
        HttpSession session = request.getSession();
        User_DAO dao = new User_DAO();
        Account acc = dao.getUSer(username, HashPassword.getHashedPassword(password));
        System.out.println(acc);
        if (acc == null) {
            request.setAttribute("error", "Username or password is not valid!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            session.setAttribute("role", 0);

        } else if (!acc.isStatus()) {
            request.setAttribute("error", "Account is blocked! ");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            session.setAttribute("role", 0);
        } else {
            Cookie uid = new Cookie("uid", acc.getUID());
            uid.setMaxAge(36000);
            response.addCookie(uid);
            request.removeAttribute("error");
            session.setAttribute("Account", acc);
            session.setAttribute("role", acc.getRoleID());
            request.setAttribute("id", id_hotel);
            session.setAttribute("name", StringCutter.cut(acc.getFullname()));
            if (page == null || page.equals("null")) {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
