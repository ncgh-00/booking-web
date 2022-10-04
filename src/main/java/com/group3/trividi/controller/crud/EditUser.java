package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.model.Account;
import com.group3.trividi.utils.Validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        } else if (dao.checkPhone(phone)) {
            request.setAttribute("error", "Phone was used !");
            request.getRequestDispatcher("edituser.jsp").forward(request, response);
            return;
        } else if (!Validation.validPhone(phone)) {
            request.setAttribute("error", "Phone invalid");
            request.getRequestDispatcher("edituser.jsp").forward(request, response);
            return;
        }
        if (email == null) {
            email = "";
        } else if (dao.checkEmail(email)) {
            request.setAttribute("error", "Email was used !");
            request.getRequestDispatcher("edituser.jsp").forward(request, response);
            return;
        } else if (!Validation.validEmail(email)) {
            request.setAttribute("error", "Email invalid");
            request.getRequestDispatcher("edituser.jsp").forward(request, response);
            return;
        }

        if (password == null) {
            password = "";
        } else if (password.length() < 6) {
            request.setAttribute("error", "Password must be greater than 6 character !");
            request.getRequestDispatcher("edituser.jsp").forward(request, response);
            return;
        } else if (!password.equals(repass)) {
            request.setAttribute("error", "Password and repassword don't match!");
            request.getRequestDispatcher("edituser.jsp").forward(request, response);
            return;
        }
        HttpSession session = request.getSession();
        session.removeAttribute("Account");

        dao.editUser(id, password, name, phone, email);
        Account acc = dao.getUSer(id);
        session.setAttribute("Account", acc);
        session.setAttribute("role", acc.getRoleID());
        response.sendRedirect("LoadMyAccount");
    }

}
