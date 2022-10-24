package com.group3.trividi.controller.crud;

import com.group3.trividi.dao.Booking_DAO;
import com.group3.trividi.dao.User_DAO;
import com.group3.trividi.model.Account;
import com.group3.trividi.utils.DateProcessor;
import com.group3.trividi.utils.HashPassword;
import com.group3.trividi.utils.StringCutter;
import com.group3.trividi.utils.Validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "BookRoom", value = "/BookRoom")
public class BookRoom extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String dateS = request.getParameter("dateS");
        String dateE = request.getParameter("dateE");
        String id_hotel = request.getParameter("id");
        String number = request.getParameter("numofroom");
        String idType = request.getParameter("roomtype");

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        int numberR = Integer.parseInt(number);
        int id_Type = Integer.parseInt(idType);
        Booking_DAO dao = new Booking_DAO();
        Account acc = (Account) session.getAttribute("Account");
        DateProcessor tool = new DateProcessor();
        if (DateProcessor.duration(dateS, dateE) <= 0 || !tool.isLogicDate(dateS)) {
            request.setAttribute("error", "Date is not valid!");
            request.getRequestDispatcher("LoadBooking?id_hotel=" + id_hotel).forward(request, response);
            return;
        }
        if (acc == null) {
            User_DAO u = new User_DAO();
            if(!Validation.validPhone(phone)){
                request.setAttribute("error", "Phone is invalid!");
                request.getRequestDispatcher("LoadBooking?id_hotel=" + id_hotel).forward(request, response);
                return;
            } else if(u.checkPhone(phone)){
                request.setAttribute("error", "Phone was used! Please login your account before booking!");
                request.getRequestDispatcher("LoadBooking?id_hotel=" + id_hotel).forward(request, response);
                return;
            }

            String pass = HashPassword.generatePassword(8);
            System.out.println("pass :" +pass);
            u.insert(3,phone,HashPassword.getHashedPassword(pass), name, null, phone,1);
            Account ac = u.getUSer(phone, HashPassword.getHashedPassword(pass));
            Cookie uid = new Cookie("uid",ac.getUID());
            uid.setMaxAge(24*60*60*90);
            response.addCookie(uid);
            session.setAttribute("Account", ac);
            session.setAttribute("role", ac.getRoleID());
            session.setAttribute("name", StringCutter.cut(ac.getFullname()));
            dao.insertBook(id_Type,
                    ac.getUID(),
                    dateS,
                    dateE,
                    numberR,
                    dao.getCost(id_Type));
            request.setAttribute("show", 1);
            request.setAttribute("pass",pass);
            request.getRequestDispatcher("LoadMyAccount").forward(request, response);
        } else {

            dao.insertBook(id_Type,
                    acc.getUID(),
                    dateS,
                    dateE,
                    numberR,
                    dao.getCost(id_Type));
            response.sendRedirect("LoadMyAccount");
        }
    }
}
