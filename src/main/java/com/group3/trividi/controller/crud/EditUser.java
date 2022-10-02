package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.utils.HashPassword;
import com.group3.trividi.utils.Validation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditUser", value = "/EditUser")
public class EditUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("pass");
        String repass = request.getParameter("repass");
        String phone = request.getParameter("phone");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String id = request.getParameter("id");
        User_DAO dao = new User_DAO();
        if (name == null)
            name = "";
        if (phone == null) {
            phone = "";
        } else if (!Validation.validPhone(phone)) {
            request.setAttribute("error", "Phone invalid");
            request.getRequestDispatcher("edituser.jsp").forward(request, response);
            return;
        }
        if (email == null) {
            email = "";
        } else if (!Validation.validEmail(email)) {
            request.setAttribute("error", "Email invalid");
            request.getRequestDispatcher("edituser.jsp").forward(request, response);
            return;
        } else if (dao.checkEmail(email)) {
            request.setAttribute("error", "Email was used!");
            request.getRequestDispatcher("edituser.jsp").forward(request, response);
            return;
        }

        if (password == null) {
            password = "";
        } else if (!password.equals(repass)) {
            request.setAttribute("error", "Password and repassword don't match!");
            request.getRequestDispatcher("edituser.jsp").forward(request, response);
            return;
        }

        dao.editUser(id, password, name, phone, email);
        response.sendRedirect("LoadMyAccount");
    }

}
