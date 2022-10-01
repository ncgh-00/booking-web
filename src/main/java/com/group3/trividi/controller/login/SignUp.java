package com.group3.trividi.controller.login;

import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.model.Account;
import com.group3.trividi.utils.HashPassword;
import com.group3.trividi.utils.Validation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignUp", value = "/SignUp")
public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user_name");
        String name = request.getParameter("name");
        String mail = request.getParameter("email");
        String password = request.getParameter("pass");
        String repass = request.getParameter("repass");
        String phone = request.getParameter("phone");
        String page = request.getParameter("page");
        String id_hotel = request.getParameter("id_hotel");
        HttpSession session = request.getSession();
        User_DAO dao = new User_DAO();
        boolean check = dao.checkAccount(username, mail);
        if (check) {
            request.setAttribute("errorSignup", "Username or Email was used !");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else if (password.length() < 6) {
            request.setAttribute("errorSignup", "Password must be greater than 6 character !");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else if (!password.equals(repass)) {
            request.setAttribute("errorSignup", "Password and Repassword don't match !");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else if (!Validation.validPhone(phone)) {
            request.setAttribute("errorSignup", "Phone invalid !");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else if (!Validation.validEmail(mail)) {
            request.setAttribute("errorSignup", "Email invalid !");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else {
            request.removeAttribute("errorSignup");
            dao.insert(username, HashPassword.getHashedPassword(password), name, mail, phone);
            Account acc = dao.getUSer(username, HashPassword.getHashedPassword(password));
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
